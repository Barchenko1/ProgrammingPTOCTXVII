package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;

import java.io.*;

public class DemoReader {
    public static void main(String[] args) {
        try {
            BufferedReader br=new BufferedReader(new FileReader("res"));
            String tmp="";
            while ((tmp=br.readLine())!=null){
                String[] s = tmp.split("\\s");
                for (String res : s) System.out.println(res);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
