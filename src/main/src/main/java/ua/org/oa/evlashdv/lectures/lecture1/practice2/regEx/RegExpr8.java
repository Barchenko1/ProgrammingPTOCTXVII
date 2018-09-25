package ua.org.oa.evlashdv.lectures.lecture1.practice2.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr8 {
    public static void main(String[] args) {
        String str="Jon Jonathan Frank Ken Todd";
        Pattern pat=Pattern.compile("Jon.*? ");
        Matcher mat=pat.matcher(str);

        System.out.println("исходник "+str);
        str=mat.replaceAll("Eric ");
        System.out.println("получаем "+str);
    }
}
