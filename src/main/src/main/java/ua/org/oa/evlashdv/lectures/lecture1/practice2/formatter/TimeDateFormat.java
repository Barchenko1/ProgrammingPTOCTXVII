package ua.org.oa.evlashdv.lectures.lecture1.practice2.formatter;

import java.util.Calendar;
import java.util.Formatter;

public class TimeDateFormat {
    public static void main(String[] args) {
        Formatter fmt=new Formatter();
        Calendar cal=Calendar.getInstance();

        fmt.format("%tr",cal);
        System.out.println(fmt);

        fmt=new Formatter();
        fmt.format("%tc",cal);
        System.out.println(fmt);

        fmt=new Formatter();
        fmt.format("%tl:%tM",cal,cal);
        System.out.println(fmt);

        fmt=new Formatter();
        fmt.format("%tB %tb %tm",cal,cal,cal);
        System.out.println(fmt);
        fmt.close();
    }
}
