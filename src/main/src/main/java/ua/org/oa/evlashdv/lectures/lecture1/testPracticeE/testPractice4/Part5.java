package ua.org.oa.evlashdv.lectures.lecture1.testPracticeE.testPractice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {
	private static final String BASE = "resources";
	private static final String REGEX = "(\\w+)\\s+(\\w+)";

	public static void main(String[] args) {
		String[] in=arrayToString().split(System.lineSeparator());
		for(String str:in) {
			if(str.equals("stop")) {
				break;
			}
			System.out.println(parser(str));
		}
//		String sting=
//		System.out.println(str);
	}

	private static String parser(String in) {
		StringBuilder builder=new StringBuilder();
		Pattern pattern=Pattern.compile(REGEX);
		Matcher matcher=pattern.matcher(in);
		while(matcher.find()) {
			Locale locale=new Locale.Builder().setLanguage(matcher.group(2)).build();
			ResourceBundle rb=ResourceBundle.getBundle(BASE+"_"+matcher.group(2),locale);
			builder.append(rb.getString(matcher.group(1)));
		}
		return builder.toString();
	}

	private static String arrayToString(){
		StringBuilder builder=new StringBuilder();
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()) {
			builder.append(scanner.nextLine()+System.lineSeparator());
		}
		scanner.close();
		return builder.toString();
	}
}
