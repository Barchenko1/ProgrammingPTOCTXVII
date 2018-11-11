package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.task5;

import interfaces.task2.FractionNumber;
import interfaces.task2.FractionNumberOperation;
import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;
import ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.task2.FractionNumberImpl;
import ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.task2.FractionNumberOperationImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FractionNumber fractionNumber1=new FractionNumberImpl();
        fractionNumber1.setDividend(1);
        fractionNumber1.setDivisor(2);
        FractionNumber fractionNumber2=new FractionNumberImpl();
        fractionNumber2.setDividend(3);
        fractionNumber2.setDivisor(4);
        FractionNumber fractionNumber3=new FractionNumberImpl();
        fractionNumber3.setDividend(4);
        fractionNumber3.setDivisor(5);
        FractionNumberOperation fractionNumberOperation=new FractionNumberOperationImpl();
        ArrayCollection<FractionNumber> fractionNumbers=new ArrayCollectionImpl<>();
        ArrayCollection<FractionNumber> fractionNumbers2=new ArrayCollectionImpl<>();
        System.out.println("size "+fractionNumbers2.size());
        System.out.println("isEmpty "+fractionNumbers2.isEmpty());
        fractionNumbers.add(fractionNumber1);
        fractionNumbers.add(fractionNumber2);
        fractionNumbers.add(fractionNumber3);
        fractionNumbers2.addAll(fractionNumbers);
        System.out.println("contains fn1 = "+fractionNumbers2.contains(fractionNumber1));
        System.out.print("addAll test = ");
        for (FractionNumber fractionNumber:fractionNumbers2) {
            System.out.print(fractionNumber.toStringValue()+" ");
        }
        System.out.println();
        System.out.println("containsAll = "+fractionNumbers.containsAll(fractionNumbers2));
        System.out.println("toArray = "+fractionNumbers.toArray());
        System.out.println(fractionNumbers2.size());
        //System.out.println("removeAll = "+fractionNumbers2.removeAll(fractionNumbers));
        fractionNumbers2.clear();
        for (FractionNumber fractionNumber:fractionNumbers2) {
            System.out.println(fractionNumber.toStringValue());
        }
        System.out.println(fractionNumbers2.size());
        FractionNumber fractionNumber0=new FractionNumberImpl();
        fractionNumber0.setDividend(0);
        fractionNumber0.setDivisor(1);
        for (FractionNumber fractionNumber:fractionNumbers) {
            fractionNumber0 = fractionNumberOperation.add(fractionNumber0,fractionNumber);
        }
        System.out.println("sum = "+fractionNumber0.toStringValue());

        fractionNumbers.remove(fractionNumber2);
        for (FractionNumber fractionNumber:fractionNumbers) {
            System.out.println("it's not removed = "+fractionNumber.toStringValue());
        }
        System.out.println();

        ArrayCollection<Double> arrayCollection=new ArrayCollectionImpl<>();
        ArrayIterator<Double> doubleArrayIterator= (ArrayIterator<Double>) arrayCollection.iterator();
        Double[] doubles={11.0,23.0,13.0,4.5};
//        arrayCollection.add(doubles[0]);
//        arrayCollection.add(doubles[1]);
//        arrayCollection.add(-doubles[2]);
//        arrayCollection.add(doubles[3]);
        arrayCollection.setArray(doubles);
        boolean dbool=arrayCollection.retainAll(Arrays.asList(doubles));
        System.out.println(dbool);
        for (Double d:arrayCollection) {
            System.out.println(d);
        }
        System.out.println(arrayCollection.size());
    }
}
