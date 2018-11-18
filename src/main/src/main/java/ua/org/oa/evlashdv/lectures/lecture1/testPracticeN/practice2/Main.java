package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice2;

import interfaces.task2.FractionNumber;
import interfaces.task2.FractionNumberOperation;

public class Main {
    public static void main(String[] args) {
        FractionNumberImpl firstFractionNumber = new FractionNumberImpl();
        firstFractionNumber.setDividend(0);
        firstFractionNumber.setDivisor(2);
        System.out.println(firstFractionNumber.value());
        System.out.println(firstFractionNumber.toStringValue());

        FractionNumberImpl secondFractionNumber = new FractionNumberImpl();
        secondFractionNumber.setDividend(2);
        secondFractionNumber.setDivisor(5);

        System.out.println(secondFractionNumber.value());
        System.out.println(secondFractionNumber.toStringValue());
        System.out.println("///////////");
        FractionNumberOperation fractionNumberOperatio =
                new FractionNumberOperationImpl();
        FractionNumber fractionNumberSum =
                fractionNumberOperatio.add(firstFractionNumber,
                        secondFractionNumber);
        FractionNumber fractionNumberSub =
                fractionNumberOperatio.sub(firstFractionNumber,
                        secondFractionNumber);
        FractionNumber fractionNumberMul =
                fractionNumberOperatio.mul(firstFractionNumber,
                        secondFractionNumber);
        FractionNumber fractionNumberDiv =
                fractionNumberOperatio.div(firstFractionNumber,
                        secondFractionNumber);

        System.out.println(fractionNumberSum.toStringValue());
        System.out.println(fractionNumberSub.toStringValue());
        System.out.println(fractionNumberMul.toStringValue());
        System.out.println(fractionNumberDiv.toStringValue());
    }
}
