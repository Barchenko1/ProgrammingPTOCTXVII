package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {
	private static final String BASE_NAME = "resources";
	private static final String REGEX = "(\\w+)\\s+(\\w+)";
	
	public static void main(String[] args) {
		String input=byteArrayToString();
		StringBuilder build = new StringBuilder();
		Pattern patt = Pattern.compile(REGEX);
		Matcher match = patt.matcher(input);
		while(match.find()) {
			Locale local=new Locale.Builder().setLanguage(match.group(2)).build();
			ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME + "_" + match.group(2), local);
			build.append(bundle.getString(match.group(1)) + "\n");
		}
		System.out.println(build);

	}
	private static String byteArrayToString() {
		StringBuilder build = new StringBuilder();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			build.append(scan.nextLine() + "\n");
		}
		scan.close();
		return build.toString();
	}
}
