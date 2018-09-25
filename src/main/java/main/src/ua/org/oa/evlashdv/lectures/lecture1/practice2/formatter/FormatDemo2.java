package ua.org.oa.evlashdv.lectures.lecture1.practice2.formatter;

import java.util.Formatter;

public class FormatDemo2 {
    public static void main(String[] args) {
        Formatter frm=new Formatter();
        for (double i=1.23;i<1.0e+6;i+=100){
            frm.format("%f %e",i,i);
            System.out.println(frm);
        }
        frm.close();
    }
}
