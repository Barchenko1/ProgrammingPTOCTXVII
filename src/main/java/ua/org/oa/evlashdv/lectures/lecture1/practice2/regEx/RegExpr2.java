package ua.org.oa.evlashdv.lectures.lecture1.practice2.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr2 {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("Java");
        Matcher matcher=pattern.matcher("Java 8");
        if (matcher.find()) System.out.println("найдена последовательность");
        else System.out.println("совпадений не найдено");
    }
}
