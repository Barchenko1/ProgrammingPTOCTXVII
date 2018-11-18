package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice6;

import interfaces.task6.IOUtils;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.Reader;
import java.io.Writer;

public class Main {
    public static void main(String[] args) {
        String road1 = "testIODir";
        IOUtils ioUtils = new IOUtilsImpl();
        String[] files1 = ioUtils.findFiles(road1);
        for (String f:files1) {
            System.out.println("file: " + f);
        }
        System.out.println("///////////");
        String road2 = "testIODir";
        String[] files2 = ioUtils.findFiles(road2, "java");
        for (String f:files2) {
            System.out.println("file: " + f);
        }
        ////////////

        char[] ca = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        char[] cb = new char[ca.length];
        Reader reader = new CharArrayReader(ca);
        Writer writer = new CharArrayWriter();
        for (int i = 0; i < ca.length; i++) {
            System.out.print(ca[i] + " ");
        }
        System.out.println();
        ioUtils.replaceChars(reader, writer, "345", "480");

        for (int i = 0; i < ca.length; i++) {
            System.out.print(ca[i] + " ");
        }
        System.out.println();
        //////////////// not buffer
        long start;
        long end;
        String source = "/home/NIX/barchenko/IdeaProjects/MyFirstTest"
                + "/testIODir/source.txt";
        String dest = "/home/NIX/barchenko/IdeaProjects/MyFirstTest"
                + "/testIODir/desc.txt";
        start = System.nanoTime();
        long scope;
        ioUtils.copyFile(source, dest);
        end = System.nanoTime();
        scope = end - start;
        System.out.println("copyFile = " + scope);
        ////////// buffer
        File sourceFile = new File(source);
        File destFile = new File(dest);
        start = System.nanoTime();
        ioUtils.copyFileBuffered(sourceFile, destFile);
        end = System.nanoTime();
        scope = end - start;
        System.out.println("copyFileBuffered = " + scope);
        /////////// my copy test
        start = System.nanoTime();
        ioUtils.copyFileBest(source, dest);
        end = System.nanoTime();
        scope = end - start;
        System.out.println("copyFileBest = " + scope);

    }
}
