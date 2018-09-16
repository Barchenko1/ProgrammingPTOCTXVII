package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice4;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterable<String> {
	private static final String FILE = "part4.txt";
	private static final String ENCODING = "Cp1251";
	private static final String REGEX = "(?:\\w+(?:\\s+|\\,\\s+))*\\w+\\.";
	public static void main(String[] args) {
		Part4 part4=new Part4();
		for(String str:part4) {
			System.out.println(str);
		}
	}

	@Override
	public Iterator<String> iterator() {
		return new MyIterator();
	}

	private static class MyIterator implements Iterator<String> {

		private Pattern pattern=Pattern.compile(REGEX,Pattern.UNICODE_CHARACTER_CLASS);
		private Matcher matcher=pattern.matcher(useFile());
		private int count;


		@Override
		public boolean hasNext() {
			if (matcher.find(count))
				return true;
			count = 0;
			return false;
		}

		@Override
		public String next() {
			StringBuilder sb = new StringBuilder();
			if (hasNext() && matcher.find(count)) {
				sb.append(matcher.group());
				count = matcher.end();
			} else count = 0;
			sb.toString().replaceAll(System.lineSeparator(), " ");
			return sb.toString().replaceAll(System.lineSeparator(), "");
		}

		private static StringBuilder useFile()  {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE),ENCODING));
				StringBuilder builder=new StringBuilder();
				String test;
				while ((test=reader.readLine())!=null) {
					builder.append(test+System.lineSeparator());
				}
				reader.close();
				return builder;
			} catch (IOException e) {
				e.printStackTrace();
				return new StringBuilder();
			}
		}
	}
}
