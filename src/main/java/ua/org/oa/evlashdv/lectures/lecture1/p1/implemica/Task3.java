package ua.org.oa.evlashdv.lectures.lecture1.p1.implemica;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class Task3 {
    private static double fact(int num){ // Method to find factorial of given number
        return (num==0) ? 1 : num*fact(num-1);
    }

    private static BigInteger factBig(int n){ // Method to find factorial of given big number
        BigInteger res=BigInteger.ONE;
        for (int i = 2; i <=n ; i++) {
            res=res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
    private static List<Integer> toNumbersList(BigInteger number) {  // Method to create a list of numbers
        String numberToStr = String.valueOf(number);    //String of numbers
        char[] charArray = numberToStr.toCharArray();   //Char array of string
        List<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 0;i<charArray.length; i++){
            int c = Character.getNumericValue(charArray[i]);    //Get char and shift to integer
            listOfNumbers.add(c);   //Add all chars to list of numbers
        }
        return listOfNumbers;
    }
    private static int getSumOfNumbers(BigInteger bigNumber) { //Method to summation numbers
        List<Integer> intList=toNumbersList(bigNumber);
        int sum=0;
        for (int i = 0; i <intList.size(); i++) {
            sum+= intList.get(i);   //Summation of all numbers in the array
        }
        return sum;
    }
    public static void main(String[] args) {
        BigInteger BigNumber=factBig(100);
        System.out.println(BigNumber);
        System.out.println(toNumbersList(BigNumber));
        int sum = getSumOfNumbers(BigNumber);
        System.out.println(sum); //Total sum of factorial 100
    }
}
