package ua.org.oa.evlashdv.lectures.lecture1.lecture6b;

import java.io.*;

import java.util.ArrayList;

public class Try1 {
    private static final String path = "/main/resources/data2";
    private static ArrayList<String> listWithFileNames = new ArrayList<>();
    public static void main(String[] args) {
        getListFiles("D:\\Siemens NX");

        for (String fil : listWithFileNames) {
            System.out.println(fil);
        }
        writeBullshit(String.valueOf(listWithFileNames), getFile(path));
    }

    public static void getListFiles(String str) {
        File f = new File(str);
        for (File s : f.listFiles()) {
            if (s.isFile()) {
                listWithFileNames.add(String.valueOf(s));
            } else if (s.isDirectory()) {
                getListFiles(s.getAbsolutePath());
            }
        }
    }
    private static void writeBullshit(String listWithFileNames, File file){
        System.out.println("START writeBullshit()");
        try(FileOutputStream outputStream = new FileOutputStream(file)){

            byte [] bullshitInBytes = listWithFileNames.getBytes();
            outputStream.write(bullshitInBytes);

        } catch (IOException e) {

        }
        System.out.println("END writeBullshit()");
    }
    private static File getFile(String path){
        File file = null;
        try {
            file = new File(path);

            if(!file.exists()) {
                System.out.println("File not exists");
                System.out.println();
                System.out.println("Create File");
                file.createNewFile();
            } else {
                System.out.println("File exists");
            }
        } catch (IOException e){
            System.out.println("Lemon school IO Exception");
        }
        return file;
    }
}