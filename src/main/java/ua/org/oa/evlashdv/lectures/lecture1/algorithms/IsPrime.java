package ua.org.oa.evlashdv.lectures.lecture1.algorithms;

public class IsPrime {
    public static void main(String[] args) {
        System.out.println(isPrime(7));
    }

    private static boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i * i <= n; ++i) {
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
}
