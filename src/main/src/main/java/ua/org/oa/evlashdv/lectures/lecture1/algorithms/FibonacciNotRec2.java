package ua.org.oa.evlashdv.lectures.lecture1.algorithms;

public class FibonacciNotRec2 {
    public static void main(String[] args) {
        System.out.println(FibonacciNotRecursive(6));
    }

    private static int FibonacciNotRecursive(int n) {
        if (n==0) return 1;
        int f0=1;
        int f1=1;
        for (int i=2;i<n;++i){
            int temp=f1;
            f1+=f0;
            f0=temp;
        }
        return f1;
    }
}
