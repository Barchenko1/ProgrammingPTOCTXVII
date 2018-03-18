package ua.org.oa.evlashdv.lectures.lecture1.practices;

public class FastExponentiation {
    public static void main(String[] args) {
        System.out.println(Power(3,4));
    }

    private static double Power(double a,int n) {
        double result=1;
        double aInDegreeOf2=a;
        while (n>0){
            if ((n&1)==1){
                result*=aInDegreeOf2;
            }
            aInDegreeOf2*=aInDegreeOf2;
            n=n>>2;
        }
        return result;
    }
}
