package ua.org.oa.evlashdv.lectures.lecture1.testPracticeE.testPractice4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

	private static final String FILE = "part1.txt";
	private static final String ENCODING = "Cp1251";
	private static final String REGEX = "(\\w{4,})";

	public static void main(String[] args) throws IOException {
		StringBuilder builder=new StringBuilder();
		StringBuffer buffer = new StringBuffer();
		useFile(builder);
		changeCase(builder, buffer);
		//builder.delete(builder.length()-1, builder.length());
		System.out.println(buffer);

	}

	private static void useFile(StringBuilder builder) throws IOException {
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(FILE),ENCODING));
		String test;
		while ((test=reader.readLine())!=null) {
			builder.append(test+"\n");
		}
		reader.close();
		builder.delete(builder.length()-1, builder.length());
	}

	private static void changeCase(StringBuilder builder, StringBuffer buffer) {
		Pattern pattern=Pattern.compile(REGEX,Pattern.UNICODE_CHARACTER_CLASS);
		Matcher match=pattern.matcher(builder);
		while(match.find()) {
			match.appendReplacement(buffer, match.group().toUpperCase());
		}
		match.appendTail(buffer);
	}

}
