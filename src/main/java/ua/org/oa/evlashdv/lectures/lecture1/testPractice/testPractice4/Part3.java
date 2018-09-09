package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
	private static final String FILE_NAME = "part3.txt";

	private static final String ENCODING = "Cp1251";

	private static final String REGEX_CHAR = "(?<!\\w)[\\w](?!\\w+)";

	private static final String REGEX_STRING = "[a-zA-Zà-ÿÀ-ß]{2,}";

	private static final String REGEX_INT = "(?<=\\s)\\d+(?=\\s)";

	private static final String REGEX_DOUBLE = "(\\d*\\.\\d*)";
	
	public static void main(String[] args) throws IOException {
		StringBuilder input = readTheFile();
		StringBuilder result = new StringBuilder();
		String[] array = byteArrayToString().split("\n");
		for (String test : array) {
			if (test.toLowerCase().equals("char")) {
				result.append("char ==> " + parsedString(input, REGEX_CHAR) + "\n");
				continue;
			}
			if (test.toLowerCase().equals("string")) {
				result.append("String ==> " + parsedString(input, REGEX_STRING) + "\n");
				continue;
			}
			if (test.toLowerCase().equals("int")) {
				result.append("int ==> " + parsedString(input, REGEX_INT) + "\n");
				continue;
			}
			if (test.toLowerCase().equals("double")) {
				result.append("double ==> " + parsedString(input, REGEX_DOUBLE) + "\n");
				continue;
			}
		}
		result.delete(result.length() - 1, result.length());
		System.out.println(result);
	}
	private static StringBuilder readTheFile() throws IOException {
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME), ENCODING));
		StringBuilder build = new StringBuilder();
		String test;
		while ((test = buffReader.readLine()) != null) {
			build.append(test + "\n");
		}
		buffReader.close();
		return build;
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
	private static String parsedString(StringBuilder build, String regex) {
		StringBuilder result = new StringBuilder();
		Pattern patt = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
		Matcher match = patt.matcher(build);
		while (match.find()) {
			result.append(match.group() + " ");
		}
		result.delete(result.length() - 1, result.length());
		return result.toString();
	}

}
