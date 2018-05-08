package ua.org.oa.evlashdv.lectures.lecture1.p1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFiles {
    public static void main(String[] args) {
        double data[]={1,10,50,200,5000};
        try {
            RandomAccessFile rf=new RandomAccessFile("temp","rw");
            for (double d:data) {
                rf.writeDouble(d);
            }
            for (int i = data.length-1; i>=0; i--) {
                rf.seek(i*8);
                System.out.println(rf.readDouble());
            }
            rf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
