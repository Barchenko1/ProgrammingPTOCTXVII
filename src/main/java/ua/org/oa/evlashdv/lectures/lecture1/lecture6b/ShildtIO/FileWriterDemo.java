package ua.org.oa.evlashdv.lectures.lecture1.lecture6b.ShildtIO;

import java.io.*;

public class FileWriterDemo {
    public static void main(String[] args) {
        String source="Now is the time for all good men\n" +
                " to come to the aid of their country\n" +
                " and pay their due taxis.";
        char buffer[]=new char[source.length()];
        source.getChars(0,source.length(),buffer,0);

        try (FileWriter f0=new FileWriter("file1");
             FileWriter f1=new FileWriter("file2");
             FileWriter f2=new FileWriter("file3");){

            for (int i = 0; i < buffer.length; i++) {
                f0.write(buffer[i]);
            }
            f1.write(buffer);
            f2.write(buffer,buffer.length-buffer.length/4,buffer.length/4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
