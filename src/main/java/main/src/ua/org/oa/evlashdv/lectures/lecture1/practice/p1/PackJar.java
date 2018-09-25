package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.Deflater;

public class PackJar {
    static void pack(String [] filesToJar,String jarFileName,byte[]byffer){
        try {
            JarOutputStream jos=new JarOutputStream(new FileOutputStream(jarFileName));
            jos.setLevel(Deflater.DEFAULT_COMPRESSION);
            for (int i = 0; i < filesToJar.length; i++) {
                System.out.println(i);
                jos.putNextEntry(new JarEntry(filesToJar[i]));
                FileInputStream in=new FileInputStream(filesToJar[i]);
                int len;
                while ((len=in.read())>0){
                    jos.write(byffer,0,len);
                }jos.closeEntry();
                jos.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Создание jar-архива");
        String [] filesToJar=new String [2];
        filesToJar[0] = "chapt09//UseJar.java";
        filesToJar[1] = "chapt09//UseJar.class";
        byte[] buffer = new byte[1024];
// имя полученного архива
        String jarFileName = "example.jar";
        pack(filesToJar, jarFileName, buffer);
    }
}
