package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice2;

import interfaces.task2.FractionNumber;
import interfaces.task2.FractionNumberOperation;

public class FractionNumberOperationImpl implements FractionNumberOperation {
    @Override
    public FractionNumber add(FractionNumber fractionNumber1,
            FractionNumber fractionNumber2) {

        FractionNumber resultFractionNumber = new FractionNumberImpl();

        int lcmNumber = lcm(fractionNumber1.getDivisor(),
                fractionNumber2.getDivisor());
        resultFractionNumber.setDivisor(lcmNumber);

        int firstDividend = (lcmNumber / fractionNumber1.getDivisor())
                * fractionNumber1.getDividend();
        int secondDividend = (lcmNumber / fractionNumber2.getDivisor())
                * fractionNumber2.getDividend();
        int sumDividend = firstDividend + secondDividend;

        resultFractionNumber.setDividend(sumDividend);

        return resultFractionNumber;
    }

    @Override
    public FractionNumber sub(FractionNumber fractionNumber1,
            FractionNumber fractionNumber2) {
        FractionNumber resultFractionNumber = new FractionNumberImpl();

        int lcmNumber = lcm(fractionNumber1.getDivisor(),
                fractionNumber2.getDivisor());
        resultFractionNumber.setDivisor(lcmNumber);

        int firstDividend = (lcmNumber / fractionNumber1.getDivisor())
                * fractionNumber1.getDividend();
        int secondDividend = (lcmNumber / fractionNumber2.getDivisor())
                * fractionNumber2.getDividend();

        int sumDividend = firstDividend - secondDividend;
        resultFractionNumber.setDividend(sumDividend);

        return resultFractionNumber;
    }

    @Override
    public FractionNumber mul(FractionNumber fractionNumber1,
            FractionNumber fractionNumber2) {
        FractionNumber resultFractionNumber = new FractionNumberImpl();


        resultFractionNumber.setDividend(fractionNumber1.getDividend()
                * fractionNumber2.getDividend());
        resultFractionNumber.setDivisor(fractionNumber1.getDivisor()
                * fractionNumber2.getDivisor());

        return resultFractionNumber;
    }

    @Override
    public FractionNumber div(FractionNumber fractionNumber1,
            FractionNumber fractionNumber2) {
        if (fractionNumber2.getDividend() == 0) {
            throw new ArithmeticException();
        }
        FractionNumber resultFractionNumber = new FractionNumberImpl();

        resultFractionNumber.setDividend(fractionNumber1.getDividend()
                * fractionNumber2.getDivisor());
        resultFractionNumber.setDivisor(fractionNumber1.getDivisor()
                * fractionNumber2.getDividend());

        return resultFractionNumber;
    }

    private static int gcd(int a,int b) {
        return b == 0 ? a : gcd(b,a % b);
    }

    private static int lcm(int a,int b) {
        return a / gcd(a,b) * b;
    }
}
