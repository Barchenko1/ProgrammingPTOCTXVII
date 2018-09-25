package ua.org.oa.evlashdv.lectures.lecture1.practice2.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr3 {
    public static void main(String[] args) {
        Pattern pat=Pattern.compile("test");
        Matcher matcher=pat.matcher("test123test");
        while (matcher.find()){
            System.out.println("индексы последовательности "+matcher.start());
        }
    }
}
