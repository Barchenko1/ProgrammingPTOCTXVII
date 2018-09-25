package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice3.part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    private final static String REGEX = "((?<=\\n)\\w+);(\\w+\\s*\\w+);(\\w+@[a-z]+.[a-z]+)";

    public static String convert1(String input) {
        StringBuilder build = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX,Pattern.UNICODE_CHARACTER_CLASS);
        Matcher match = pattern.matcher(input);
        while (match.find()) {
            build.append(match.group(1) + " ==> " + match.group(3) + "\n");
        }
        return build.toString();
    }
    public static String convert2(String input) {
        StringBuilder build = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX,Pattern.UNICODE_CHARACTER_CLASS);
        Matcher match = pattern.matcher(input);
        while (match.find()) {
            build.append(match.group(2) + " (email: " + match.group(3) + ")\n");

        }
        return build.toString();
    }
    public static String convert3(String input){
        StringBuilder builder=new StringBuilder();
        String mail="((?<=\\n)\\w+)(?=;(\\w+\\s*\\w+);(\\w+@[a-z]+.ru))";
        String gmail="((?<=\\n)\\w+)(?=;(\\w+\\s*\\w+);(\\w+@[a-z]+.com))";
        Pattern mailPattern=Pattern.compile(mail,Pattern.UNICODE_CHARACTER_CLASS);
        Matcher mailMatch=mailPattern.matcher(input);
        Pattern gmailPattern=Pattern.compile(gmail,Pattern.UNICODE_CHARACTER_CLASS);
        Matcher gmailMatch=gmailPattern.matcher(input);
        boolean flag=true;
        while (mailMatch.find()){
            if (flag){
                builder.append("mail.ru ==> "+mailMatch.group()+", ");
                flag=false;
                continue;
            }
            builder.append(mailMatch.group()+", ");
        }
        builder.delete(builder.length()-2 ,builder.length());
        while (gmailMatch.find()){
            if (!flag){
                builder.append("\ngoogle.com ==> "+gmailMatch.group()+", ");
                flag=true;
                continue;
            }
            builder.append(gmailMatch.group()+", ");
        }
        builder.delete(builder.length()-2 ,builder.length());
        return builder.toString();
    }
    public static String convert4(String input){
        StringBuilder bilder=new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX,Pattern.UNICODE_CHARACTER_CLASS);
        Matcher match = pattern.matcher(input);
        String pass="(\\w+);(\\w+);(\\w+)";
        Pattern patternPass=Pattern.compile(pass,Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matchPass=patternPass.matcher(input);
        if (matchPass.find()){
            bilder.append(matchPass.group()+";Password\n");
        }
        while (match.find()){
            bilder.append(match.group()+";"+(int)((Math.random()*9000)+1000)+"\n");
        }
        return bilder.toString();
    }
}
