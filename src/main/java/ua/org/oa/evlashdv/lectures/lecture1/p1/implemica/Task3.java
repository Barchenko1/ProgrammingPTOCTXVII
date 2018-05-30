package ua.org.oa.evlashdv.lectures.lecture1.p1.implemica;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class Task3 {
    static double fact(int num){
        return (num==0) ? 1 : num*fact(num-1);
    }
    static BigInteger factB(int n){
        BigInteger res=BigInteger.ONE;
        for (int i = 2; i <=n ; i++) {
            res=res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
    public static List<Integer> DigitsInNumber(BigInteger number) {
        String n = String.valueOf(number);
        char[] charArray = n.toCharArray();
        List<Integer> cia = new ArrayList<Integer>();
        for (int i = 0;i<charArray.length; i++){
            int c = Character.getNumericValue(charArray[i]);
            cia.add(c);
        }
        return cia;
    }
    public static void main(String[] args) {
        System.out.println(fact(100));
        BigInteger BigN=factB(100);
        System.out.println(factB(100));
        List<Integer> iList=DigitsInNumber(BigN);
        System.out.println(DigitsInNumber(BigN));
        int sum=0;
        for (int i = 0; i <iList.size(); i++) {
            sum+= iList.get(i);
        }
        System.out.println(sum);
    }
}
