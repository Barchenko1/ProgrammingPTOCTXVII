package ua.org.oa.evlashdv.lectures.lecture1.practice2.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr4 {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("W+");
        Matcher matcher=pattern.matcher("W WW WWW");
        while (matcher.find()){
            System.out.println("совпадения "+matcher.group());
        }
    }
}
