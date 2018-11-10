package ua.org.oa.evlashdv.lectures.lecture1.testPracticeE.testPractice1;

import java.util.Arrays;

public class Part6{
	public static void main(String[] args){
		int num1=Integer.parseInt(args[0]);
		System.out.print("N= "+num1+" :");
		int arr[]=new int[num1];
		int nextNum = 2;
		int counter = 0;
		boolean isSimple;
		while (counter < num1) {
			int i = 0;
			isSimple = true;
			while (isSimple && i < counter) {
				if (nextNum % arr[i] == 0) {
					isSimple = false;
				}
				i++;
			}
			if (isSimple) {
				arr[counter] = nextNum;
				counter++;
				nextNum++;
			} else {
				nextNum++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}