package ua.org.oa.evlashdv.lectures.lecture1.testPracticeE.testPractice1;
public class Part2{
	public static void main(String[] args){
		int num1=Integer.parseInt(args[0]);
		int num2=Integer.parseInt(args[1]);
		System.out.println(args[0]+"+"+args[1]+"="+sum(num1, num2));

	}
	static int sum(int a,int b){
		return a+b;
	}
}