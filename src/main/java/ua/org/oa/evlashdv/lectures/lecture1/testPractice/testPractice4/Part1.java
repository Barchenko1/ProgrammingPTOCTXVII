package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
	private static final String FILE_NAME = "part1.txt";
	private static final String ENCODING = "Cp1251";
	private static final String REGEX = "(\\w{4,})";
	public static void main(String[] args) throws IOException {
		StringBuilder builder=new StringBuilder();
		StringBuffer buffForCopy = new StringBuffer();
		String test;
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME),ENCODING));
		while((test=buffReader.readLine())!=null) {
			builder.append(test+"\n");
		}
		buffReader.close();
		Pattern patt = Pattern.compile(REGEX, Pattern.UNICODE_CHARACTER_CLASS);
		Matcher match = patt.matcher(builder);
		while(match.find()) {
			match.appendReplacement(buffForCopy, match.group().toUpperCase());
		}
		match.appendTail(buffForCopy);
		buffForCopy.delete(buffForCopy.length()-1, buffForCopy.length());
		System.out.println(buffForCopy);
		
		
		
	}

}
