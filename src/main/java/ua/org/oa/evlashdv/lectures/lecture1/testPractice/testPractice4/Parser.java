package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements Iterable<String>{
	private String fileName;

	private String encoding;

	private static final String REGEX = "(?:\\w+(?:\\s+|\\,\\s+))*\\w+\\.";
	public Parser(String fileName, String encoding) {
		this.fileName = fileName;
		this.encoding = encoding;
	}
	private StringBuilder readTheFile() {
		StringBuilder build = new StringBuilder();
		String test;
		try {BufferedReader buffReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(fileName), encoding));
		
		while ((test = buffReader.readLine()) != null) {
			build.append(test + "\n");
		}
		buffReader.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			return new StringBuilder();
		}
		
		return build;
	}
	
	@Override
	public Iterator<String> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<String> {

		private StringBuilder build = readTheFile();

		private Pattern patt = Pattern.compile(REGEX, Pattern.UNICODE_CHARACTER_CLASS);

		private Matcher match = patt.matcher(build);

		private int coincidences = numberOfCoincidences();

		private int count;

		@Override
		public boolean hasNext() {
			if (count == coincidences) {
				return false;
			}
			count++;
			return true;
		}

		@Override
		public String next() {
			StringBuilder result = new StringBuilder();
			if (match.find()) {
				result.append(match.group() + "\n");
			}
			result.delete(result.length() - 1, result.length());
			return result.toString();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		private int numberOfCoincidences() {
			int result = 0;
			while (match.find()) {
				result++;
			}
			match.reset();
			return result;
		}
	}

}
