package ua.org.oa.evlashdv.lectures.lecture1.practice2.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr7 {
    public static void main(String[] args) {
        Pattern pat=Pattern.compile("[a-z]+");
        Matcher mat=pat.matcher("this is a test");
        while (mat.find()){
            System.out.println("совпадения "+mat.group());
        }
    }
}
