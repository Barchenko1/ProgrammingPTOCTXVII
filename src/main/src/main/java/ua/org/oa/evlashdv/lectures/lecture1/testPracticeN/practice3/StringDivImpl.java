package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice3;

import interfaces.task3.StringDiv;

public class StringDivImpl implements StringDiv {

    @Override
    public double div(String s1, String s2) {
        double a;
        double b;
        if (s1 == null || s2 == null) {
            throw new NullPointerException();
        } else if (s2.equals("0")) {
            throw new ArithmeticException();
        }
        try {
            a = Double.parseDouble(s1);
            b = Double.parseDouble(s2);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        return a / b;
    }
}
