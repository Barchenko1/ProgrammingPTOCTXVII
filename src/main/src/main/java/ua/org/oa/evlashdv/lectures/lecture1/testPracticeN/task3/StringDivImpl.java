package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.task3;

import interfaces.task3.StringDiv;
import interfaces.task3.StringUtils;

public class StringDivImpl implements StringDiv {
    @Override
    public double div(String s1, String s2) {
        if (s2 == "0") {
            throw new ArithmeticException();
        }
        if (s1 == null) {
            throw new NullPointerException();
        }
        StringUtils stringUtils = new StringUtilsImpl();
        double d1=stringUtils.parseDouble(s1);
        double d2=stringUtils.parseDouble(s2);
        if (d2 == 0) {
            throw new IllegalArgumentException();
        }
        return d1/d2;
    }
}
