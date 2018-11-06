package ua.org.oa.evlashdv.lectures.lecture1.testPractice;

import interfaces.task2.FractionNumber;
import interfaces.task2.FractionNumberOperation;

public class FractionNumberOperationImpl implements FractionNumberOperation {
    @Override
    public FractionNumber add(FractionNumber fractionNumber, FractionNumber fractionNumber1) {
        FractionNumber result=new FractionNumberImpl();
        int a=fractionNumber.getDivisor();
        int b=fractionNumber1.getDivisor();
        int lcmNumber=lcm(a,b);
        result.setDivisor(lcmNumber);
        int chislitet=(lcmNumber/fractionNumber.getDivisor())*fractionNumber1.getDividend();
        int chislitet1=(lcmNumber/fractionNumber1.getDivisor())*fractionNumber1.getDividend();
        int sumChislitel=chislitet+chislitet1;
        result.setDividend(sumChislitel);

        return result;
    }

    @Override
    public FractionNumber sub(FractionNumber fractionNumber, FractionNumber fractionNumber1) {
        FractionNumber result=new FractionNumberImpl();
        int a=fractionNumber.getDivisor();
        int b=fractionNumber1.getDivisor();
        int lcmNumber=lcm(a,b);
        result.setDivisor(lcmNumber);
        int chislitet=(lcmNumber/fractionNumber.getDivisor())*fractionNumber1.getDividend();
        int chislitet1=(lcmNumber/fractionNumber1.getDivisor())*fractionNumber1.getDividend();
        int subChislitel=chislitet-chislitet1;
        result.setDividend(subChislitel);
        return result;
    }

    @Override
    public FractionNumber mul(FractionNumber fractionNumber, FractionNumber fractionNumber1) {
        FractionNumber resMul=new FractionNumberImpl();
        int a1=fractionNumber.getDivisor();
        int a2=fractionNumber1.getDivisor();
        int b1=fractionNumber.getDividend();
        int b2=fractionNumber1.getDividend();
        int lcmNumber1=gcd(b1,a2);
        int lcmNumber2=gcd(a1,b2);
        fractionNumber.setDividend(fractionNumber.getDividend()/lcmNumber1);
        fractionNumber1.setDivisor(fractionNumber1.getDivisor()/lcmNumber2);

        fractionNumber.setDivisor(fractionNumber.getDivisor()/lcmNumber2);
        fractionNumber1.setDividend(fractionNumber1.getDividend()/lcmNumber2);

        resMul.setDividend(fractionNumber.getDividend()*fractionNumber1.getDividend());
        resMul.setDivisor(fractionNumber.getDivisor()*fractionNumber1.getDivisor());
        return resMul;
    }

    @Override
    public FractionNumber div(FractionNumber fractionNumber, FractionNumber fractionNumber1) {
        return null;
    }

    public static int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a % b);
    }
    public static int lcm(int a,int b){
        return a / gcd(a,b) * b;
    }
}
