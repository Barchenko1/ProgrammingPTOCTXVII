package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.task3;

import interfaces.task3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtilsImpl implements StringUtils {

    private static final String REGEX_DOUBLE = "(\\d*\\.\\d*)";

    @Override
    public String invert(String s) {
        if (s==null){
            return "";
        }
        return new StringBuilder(s).reverse().toString();
    }

    @Override
    public String compareWords(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        char[] charsArr=s2.toCharArray();
        for (int i = 0; i <s1.length() ; i++) {
            char c=s1.charAt(i);
            for (int j = 0; j < charsArr.length; j++) {
                if (charsArr[j] == c) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    @Override
    public double parseDouble(String s) {
        String regexWithE = "(^[-]?\\d*[.]?\\d+){1}(([e]{1}[-+]{1}\\d+){1}|[ \\t\\n\\x0B\\f\\r]{1}|$)";

        Pattern pattern = Pattern.compile(regexWithE);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            String tempStr=matcher.group();
            double d =Double.parseDouble(tempStr);
            return d;
        } else {
            throw new IllegalArgumentException(new Error());
        }
    }
}
