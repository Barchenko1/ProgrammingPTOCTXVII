package ua.org.oa.evlashdv.lectures.lecture1.practice2.regEx;


import java.util.regex.Pattern;

public class RegExpr9 {
    public static void main(String[] args) {
        Pattern pattern= Pattern.compile("[ ,.!]");
        String strs[]=pattern.split("one two,alpha9 12!done.");
        for (int i = 0; i <strs.length ; i++) {
            System.out.println("сл лексема "+strs[i]);
        }
    }
}
