package ua.org.oa.evlashdv.lectures.lecture1.p1;

import java.io.*;

public class DemoWriter {
    public static void main(String[] args) {
        File f=new File("res");
        FileWriter fw=null;
        try {
            fw= new FileWriter(f,true);
        } catch (IOException e) {
            System.err.println("ошибка открытия потока " + e);
            System.exit(1);
        }
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        double[] v={1.1,1.2,1.401,5.01};
        for (double version:v) {
            pw.printf("Java %.2g%n",version);
        }
        pw.close();

    }
}
