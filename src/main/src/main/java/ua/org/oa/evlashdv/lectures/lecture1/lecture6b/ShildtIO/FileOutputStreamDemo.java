package ua.org.oa.evlashdv.lectures.lecture1.lecture6b.ShildtIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        String source="Now is the time for all good men\n" +
                " to come to the aid of their country\n" +
                " and pay their due taxis.";
        byte buf[]=source.getBytes();
        FileOutputStream f0=null;
        FileOutputStream f1=null;
        FileOutputStream f2=null;

        try {
            f0=new FileOutputStream("file1.txt");
            f1=new FileOutputStream("file2.txt");
            f2=new FileOutputStream("file3.txt");
            for (int i = 0; i <buf.length ; i++) {
                f0.write(i);
            }
            f1.write(buf);
            f2.write(buf,0,buf.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (f0!=null) f0.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (f1!=null) f1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (f2!=null) f2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
