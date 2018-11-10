package ua.org.oa.evlashdv.lectures.lecture1.testPracticeE.testPractice1;
public class Part4{
	public static void main(String[] args){
		int num1=Integer.parseInt(args[0]);
		int num2=Integer.parseInt(args[1]);
        System.out.println("НОД "+args[0]+" и "+args[1]+"="+algorithm(num1, num2));
    }
	public static int algorithm(int a, int b) {
        int d = 0;
        while (b != 0 && a != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
            d = a + b;
        }
        return d;
    }
}