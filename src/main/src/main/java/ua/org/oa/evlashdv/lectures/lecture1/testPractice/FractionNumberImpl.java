package ua.org.oa.evlashdv.lectures.lecture1.testPractice;

import interfaces.task2.FractionNumber;

public class FractionNumberImpl implements FractionNumber {
    private int dividend;
    private int divisor;
    @Override
    public void setDividend(int i) {
        this.dividend=i;
    }

    @Override
    public int getDividend() {
        return dividend;
    }

    @Override
    public void setDivisor(int i) {
        this.divisor=i;
    }

    @Override
    public int getDivisor() {
        return divisor;
    }

    @Override
    public double value() {
        checkNumber(dividend, divisor);
        double d=dividend*1.0/divisor;
        return d;
    }

    @Override
    public String toStringValue() {
        return dividend+"/"+divisor;
    }
    private static void checkNumber(int dividend,int divisor){
        if ((dividend/divisor)==0){
            gcd(dividend, divisor);
        }else if ((divisor/dividend)==0){
            gcd(dividend, divisor);
        }
    }
    public static int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a % b);
    }
}
