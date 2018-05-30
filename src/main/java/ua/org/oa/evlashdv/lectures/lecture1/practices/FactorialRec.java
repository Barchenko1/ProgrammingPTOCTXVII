package ua.org.oa.evlashdv.lectures.lecture1.practices;

public class FactorialRec {
    static double fact(int num){
        return (num==0) ? 1 : num*fact(num-1);
    }
    public static void main(String[] args) {
        System.out.println(FactorialRec.fact(100));
    }
}
