package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice2;

import interfaces.task2.FractionNumber;

public class FractionNumberImpl implements FractionNumber {

    private int dividend;
    private int divisor;

    @Override
    public void setDividend(int i) {
        this.dividend = i;
    }

    @Override
    public int getDividend() {
        return dividend;
    }

    @Override public void setDivisor(int i) {
        if (i == 0) {
            throw new IllegalArgumentException();
        }
        this.divisor = i;
    }

    @Override
    public int getDivisor() {
        return divisor;
    }

    @Override public double value() {
        return dividend * 1.0 / divisor;
    }

    @Override public String toStringValue() {
        return dividend + "/" + divisor;
    }
}
