package ua.org.oa.evlashdv.lectures.lecture1.testPracticeE.testPractice1;

public class Part3{
	public static void main(String[] args){
		String str=args[0];
		char[] c=str.toCharArray();
		System.out.print(args[0]+" = ");
		for(int i=0;i<c.length;i++){
			System.out.print(c[i]+" ");
		}
		System.out.println();
	}
}