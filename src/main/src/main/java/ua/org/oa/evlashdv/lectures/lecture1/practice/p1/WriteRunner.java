package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;

import java.io.*;


public class WriteRunner {
    public static void main(String[] args) {
        String pArray[]={"2007 ","Java SE6"};
        File fbyte=new File("byte");
        File fsymb=new File("symbol");
        try {
            FileOutputStream fos=new FileOutputStream(fbyte);
            FileWriter fw=new FileWriter(fsymb);
            for (String a:pArray) {
                fos.write(a.getBytes());
                fw.write(a);
            }
            fos.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
