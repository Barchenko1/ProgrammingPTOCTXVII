package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.task2;


import interfaces.task2.FractionNumber;

public class Test {
    public static void main(String[] args) {
        FractionNumber fractionNumber=new FractionNumberImpl();
        fractionNumber.setDividend(1);
        fractionNumber.setDivisor(2);
        System.out.println(fractionNumber.value());
        System.out.println(fractionNumber.toStringValue());

        FractionNumber fractionNumber1=new FractionNumberImpl();
        fractionNumber1.setDividend(3);
        fractionNumber1.setDivisor(4);
        System.out.println(fractionNumber1.value());
        System.out.println(fractionNumber1.toStringValue());

        FractionNumberOperationImpl fractionNumberOperation=new FractionNumberOperationImpl();
        FractionNumber resSum=fractionNumberOperation.add(fractionNumber,fractionNumber1);
        FractionNumber resSub=fractionNumberOperation.sub(fractionNumber,fractionNumber1);
        FractionNumber resMul=fractionNumberOperation.mul(fractionNumber,fractionNumber1);
        System.out.println(resSum.toStringValue());
        System.out.println(resSub.toStringValue());
        System.out.println(resMul.toStringValue());

    }
}
