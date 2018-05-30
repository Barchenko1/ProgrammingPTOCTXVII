package ua.org.oa.evlashdv.lectures.lecture1.practices;

public class FactorialNotRec {
    static int fact(int num){
        int fact=1;
        for (;num>0;fact*=num--);
        return fact;
    }

    public static void main(String[] args) {
        System.out.println(FactorialRec.fact(100));
    }
}
