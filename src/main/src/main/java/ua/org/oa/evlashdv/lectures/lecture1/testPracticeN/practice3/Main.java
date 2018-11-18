package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice3;

import interfaces.task3.StringDiv;
import interfaces.task3.StringUtils;

public class Main {
    public static void main(String[] args) {
        StringDiv stringDiv = new StringDivImpl();
        StringUtils stringUtils = new StringUtilsImpl();

        System.out.println(stringDiv.div("3","2"));
        System.out.println(stringUtils.parseDouble("1.2 1.5 rvf 2.2 asv"));
        System.out.println(stringUtils.invert("abcdeg"));
        System.out.println(stringUtils.compareWords("abcdt","abs"));
        System.out.println("////////");

        try {
            stringUtils.parseDouble("1.23e.11");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
