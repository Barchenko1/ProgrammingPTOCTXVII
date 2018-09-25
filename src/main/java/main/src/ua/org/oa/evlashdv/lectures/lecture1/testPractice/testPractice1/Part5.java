package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice1;
public class Part5{
	public static void main (String args[]){
		int n=Integer.parseInt(args[0]);
		int sum=0;
        while(n != 0){
        sum += (n % 10);
        n/=10;
        }
        System.out.println("Сумма цифр "+args[0]+"="+sum + " ");
    }
}