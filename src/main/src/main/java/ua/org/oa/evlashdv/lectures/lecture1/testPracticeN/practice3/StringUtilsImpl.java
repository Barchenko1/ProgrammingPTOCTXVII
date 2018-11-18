package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice3;

import interfaces.task3.StringUtils;


public class StringUtilsImpl implements StringUtils {

    @Override
    public String invert(String s) {
        if (s == null) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }

    @Override
    public String compareWords(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new NullPointerException();
        }
        char[] charsS1 = s1.toCharArray();
        StringBuilder sb = new StringBuilder(s1.length());
        for (int i = 0; i < charsS1.length; i++) {
            char c = charsS1[i];
            if (s2.indexOf(c) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Override
    public double parseDouble(String s) {
        double d;
        if (s == null) {
            throw new NullPointerException();
        } else {
            try {
                String firstElement = s.split(" ")[0];
                d = Double.parseDouble(firstElement);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return d;
    }

}
