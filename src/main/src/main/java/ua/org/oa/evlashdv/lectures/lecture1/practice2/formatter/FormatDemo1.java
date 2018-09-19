package ua.org.oa.evlashdv.lectures.lecture1.practice2.formatter;

import java.util.Formatter;

public class FormatDemo1 {
    public static void main(String[] args) {
        Formatter fmt=new Formatter();
        fmt.format("форматировать %s очень просто: %d %f", " средствами Java", 10, 98.6);
        System.out.println(fmt);
        //fmt.close();
        fmt.format("\nшестнадцатеричное число: %x, восьмеричное число: %o", 196, 196);
        System.out.println(fmt);
        fmt.close();
    }
}
