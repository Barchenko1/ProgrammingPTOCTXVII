package ua.org.oa.evlashdv.lectures.lecture1.practice2.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr {
    public static void main(String[] args) {
        Pattern pat;
        Matcher mat;
        boolean found;

        pat=Pattern.compile("Java");
        mat=pat.matcher("Java");
        found=mat.matches();

        //System.out.println("проверка совпадений Java c Java");
        if (found){
            System.out.println("совпадение");
        }else System.out.println("не совпадают");
        System.out.println();
        //System.out.println("проверка совпадений Java c Java 8");
        mat=pat.matcher("Java 8");
        found=mat.matches();
        if (found){
            System.out.println("совпадение");
        }else System.out.println("не совпадают");
    }
}
