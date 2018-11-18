package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice5;

import com.nixsolutions.barchenko.practice2.FractionNumberImpl;
import com.nixsolutions.barchenko.practice2.FractionNumberOperationImpl;
import interfaces.task2.FractionNumber;
import interfaces.task2.FractionNumberOperation;
import interfaces.task5.ArrayCollection;

public class Main {
    public static void main(String[] args) {
        FractionNumber fractionNumber0 = new FractionNumberImpl();
        fractionNumber0.setDividend(0);
        fractionNumber0.setDivisor(1);
        FractionNumber fractionNumber1 = new FractionNumberImpl();
        fractionNumber1.setDividend(1);
        fractionNumber1.setDivisor(2);
        FractionNumber fractionNumber2 = new FractionNumberImpl();
        fractionNumber2.setDividend(3);
        fractionNumber2.setDivisor(4);
        FractionNumber fractionNumber3 = new FractionNumberImpl();
        fractionNumber3.setDividend(4);
        fractionNumber3.setDivisor(5);
        ArrayCollection<FractionNumber> arrayCollection =
                new ArrayCollectionImpl();
        arrayCollection.add(fractionNumber1);
        arrayCollection.add(fractionNumber2);
        arrayCollection.add(fractionNumber3);
        FractionNumberOperation fractionNumberOperation =
                new FractionNumberOperationImpl();
        for (FractionNumber fractionNumber:arrayCollection) {
            fractionNumber0 = fractionNumberOperation.add(fractionNumber0,
                    fractionNumber);
        }
        System.out.println(fractionNumber0.toStringValue());
    }
}
