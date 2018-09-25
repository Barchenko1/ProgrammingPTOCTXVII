package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice3.part3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    private final static String REGEX = "\\b\\w";

    public static String convert6(String input){
        StringBuffer builder=new StringBuffer();
        Pattern pattern=Pattern.compile(REGEX);
        Matcher matcher=pattern.matcher(input);
        while (matcher.find()){
            matcher.appendReplacement(builder,matcher.group().toUpperCase());
        }
        matcher.appendTail(builder);
        return builder.toString();
    }
}
