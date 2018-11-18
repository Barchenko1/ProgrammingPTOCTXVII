package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice7;

import interfaces.task7.executor.SumTask;

import java.math.BigInteger;
import java.util.Random;

public class SumTaskImpl implements SumTask {
    private int count;
    private long max;
    private BigInteger bi = new BigInteger("0");

    public SumTaskImpl() {
    }

    public SumTaskImpl(int count) {
        this.count = count;
    }

    @Override
    public void setCount(int i) {
        this.count = i;
    }

    @Override
    public void setMax(long max) {
        if (max < 1) {
            throw new IllegalArgumentException();
        }
        this.max = max;
    }

    private long rnd(long max) {
        return (long) (Math.random() * max);
    }

    @Override
    public BigInteger getRandom() {
        BigInteger bigInteger = new BigInteger(String.valueOf(rnd(max)));
        return bigInteger;
    }

    @Override
    public BigInteger getResult() {
        return bi;
    }

    @Override
    public int getTryCount() {
        return count;
    }

    @Override
    public void incTryCount() {
        count++;
    }

    @Override
    public boolean execute() throws Exception {
        try {
            for (int i = count; i > 0; i--) {
                BigInteger bigInteger = getRandom();
                bi = bi.add(bigInteger);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
