package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Part2 {
	private static final String RAW_DATA = "part2.txt";
	private static final String SORTED_DATA = "part2_sorted.txt";
	private static final int N = 10;
	private static final int MAX = 50;
	
	public static void main(String[] args) throws IOException {
		StringBuilder build = new StringBuilder();
		File fileRaw = new File(RAW_DATA);
		fileRaw.createNewFile();
		BufferedWriter buffWriter1 = new BufferedWriter(new FileWriter(fileRaw));
		for (int i = 0; i < N; i++) {
			build.append((int) (Math.random() * MAX) + " ");
		}
		buffWriter1.write(build.toString());
		buffWriter1.close();
		System.out.println("input  ==> " + fileToString(fileRaw));
		File fileSorted = new File(SORTED_DATA);
		fileSorted.createNewFile();
		BufferedWriter buffWriter2 = new BufferedWriter(new FileWriter(fileSorted));
		buffWriter2.write(sorted(fileToIntArray(fileRaw)));
		buffWriter2.close();
		System.out.println("output ==> " + fileToString(fileSorted));
	}
	private static int[] fileToIntArray(File file) throws IOException {
		BufferedReader buffReader = new BufferedReader(new FileReader(file));
		String[] array = buffReader.readLine().split(" ");
		buffReader.close();
		int[] array1 = new int[N];
		for (int i = 0; i < array.length; i++) {
			array1[i] = Integer.parseInt(array[i]);
		}

		return array1;
	}
	private static String sorted(int[] array) {
		int index = 0;
		int counter = 0;
		while (true) {
			if (array[index] > array[index + 1]) {
				int q = array[index];
				array[index] = array[index + 1];
				array[index + 1] = q;
				counter = 0;
			} else {
				counter++;
			}
			index++;
			if (index == array.length - 1) {
				index = 0;
			}
			if (counter == array.length - 1)
				break;
		}
		return arrayToString(array);
	}
	private static String arrayToString(int[] array) {
		StringBuilder build = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			build.append(array[i] + " ");
		}
		return build.toString();
	}
	private static String fileToString(File file) throws IOException {
		BufferedReader buffReader = new BufferedReader(new FileReader(file));
		StringBuilder build = new StringBuilder();
		String test;
		while ((test = buffReader.readLine()) != null) {
			build.append(test);
		}
		buffReader.close();
		return build.toString();
	}

}
