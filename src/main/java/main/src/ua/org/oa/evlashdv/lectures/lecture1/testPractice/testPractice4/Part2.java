package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Part2 {
	private static final String FILE = "part2.txt";
	private static final String SORTED = "part2_sorted.txt";
	private static final int NUM = 10;
	private static final int MAXNUM = 50;

	public static void main(String[] args) throws IOException {
		StringBuilder builder=new StringBuilder();
		File file=new File(FILE);
		file.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(FILE));
		for (int i = 0; i < NUM; i++) {
			builder.append((int) (Math.random() * MAXNUM) + " ");
		}
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		System.out.println("input  ==> " + fileToString(file));
		File fileSorted=new File(SORTED);
		fileSorted.createNewFile();
		BufferedWriter writer2=new BufferedWriter(new FileWriter(fileSorted));
		writer2.write(bubbleSort(fileToIntArr(file),NUM));
		writer2.flush();
		writer2.close();
		System.out.println("output ==> " + fileToString(fileSorted));
	}

	private static String fileToString(File file) throws IOException {
		BufferedReader bufferReader = new BufferedReader(new FileReader(file));
		StringBuilder builder = new StringBuilder();
		String text;
		while((text=bufferReader.readLine())!=null) {
			builder.append(text);
		}
		bufferReader.close();
		return builder.toString();
	}

	private static int[] fileToIntArr(File file) throws IOException {
		BufferedReader bufferReader = new BufferedReader(new FileReader(file));
		String[] arr=bufferReader.readLine().split(" ");
		bufferReader.close();
		int[] arr1=new int[NUM];
		for(int i=0;i<arr.length;i++) {
			arr1[i]=Integer.parseInt(arr[i]);
		}
		return arr1;
	}

	private static String bubbleSort(int arr[], int n){
		if (n==1)
			return "";
		for (int i = 0; i <n-1 ; i++) {
			if (arr[i]>arr[i+1]){
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
			bubbleSort(arr,n-1);
		}
		return arrToString(arr);
	}

	private static String arrToString(int arr[]){
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			builder.append(arr[i]+" ");
		}
		return builder.toString();
	}
}