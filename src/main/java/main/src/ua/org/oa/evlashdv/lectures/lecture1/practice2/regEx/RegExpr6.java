package ua.org.oa.evlashdv.lectures.lecture1.practice2.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr6 {
    public static void main(String[] args) {
        Pattern pat=Pattern.compile("e.+?d");
        Matcher mat=pat.matcher("extend cup end table");
        while (mat.find()){
            System.out.println("совпадения "+mat.group());
        }
    }
}
