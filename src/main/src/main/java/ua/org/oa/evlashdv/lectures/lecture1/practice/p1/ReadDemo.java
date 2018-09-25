package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDemo {
    public static void main(String[] args) {
        File f=new File("file1");
        int b,count=0;
        try {
            FileReader is=new FileReader(f);
            while ((b=is.read())!=-1){
                System.out.println((char)b);
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
