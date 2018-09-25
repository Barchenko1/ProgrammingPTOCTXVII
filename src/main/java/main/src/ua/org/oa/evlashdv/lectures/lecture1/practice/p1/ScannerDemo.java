package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class ScannerLogic{
    static String filename="scan";
    static void scanFile(){
        try {
            FileReader fr=new FileReader(filename);
            Scanner scan=new Scanner(fr);
            while (scan.hasNext()){
                if (scan.hasNextInt())
                    System.out.println(
                            scan.nextInt() + ":int");
                else if (scan.hasNextDouble())
                    System.out.println(
                            scan.nextDouble() + ":double");
                else if (scan.hasNextBoolean())
                    System.out.println(
                            scan.nextBoolean() + ":boolean");
                else
                    System.out.println(
                            scan.next() + ":String");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    static void makeFile(){
        try {
            FileWriter fw=new FileWriter(filename);
            fw.write("2 Java 1,5 true 1.6");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class ScannerDemo {
    public static void main(String[] args) {
        ScannerLogic.makeFile();
        ScannerLogic.scanFile();
    }
}
