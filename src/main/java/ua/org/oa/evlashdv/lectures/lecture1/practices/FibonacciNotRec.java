package ua.org.oa.evlashdv.lectures.lecture1.practices;

public class FibonacciNotRec {
    public static void main(String[] args) {
        int fibCount=6;
        int[] fib=new int[fibCount];
        fib[0]=0;
        fib[1]=1;
        fib(fib,fibCount);
        print(fibCount, fib);
    }

    private static void print(int fibCount, int[] fib) {
        for (int i = 0; i <fibCount; i++) {
            System.out.print(fib[i]+" ");
        }
    }

    private static void fib(int[] fib,int fibCount) {
        for (int i = 2; i <fibCount; i++) {
            fib[i]=fib[i-1]+fib[i-2];
        }
    }
}
