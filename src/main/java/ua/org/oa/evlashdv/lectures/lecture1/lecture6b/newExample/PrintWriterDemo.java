package ua.org.oa.evlashdv.lectures.lecture1.lecture6b.newExample;

import java.io.PrintWriter;

public class PrintWriterDemo {
    public static void main(String[] args) {
        PrintWriter pw=new PrintWriter(System.out,true);
        System.out.println();
        pw.println("Это строка");
        int i=-7;
        pw.println(i);
        double d=4.5e-7;
        pw.println(d);
    }
}
