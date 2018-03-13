package ua.org.oa.evlashdv.lectures.lecture1.practices;

public class FibonacciRec {
    public static void main(String[] args) {
        System.out.println(fib(8));
    }
    static int fib(int k){
        if (k==0) return 0;
        if (k==1) return 1;
        return fib(k-1)+fib(k-2);
    }
}
