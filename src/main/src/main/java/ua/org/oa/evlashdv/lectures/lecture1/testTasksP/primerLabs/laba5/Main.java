package ua.org.oa.evlashdv.lectures.lecture1.testTasksP.primerLabs.laba5;

import interfaces.task2.FractionNumber;
import interfaces.task2.FractionNumberOperation;
import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;
import ua.org.oa.evlashdv.lectures.lecture1.testTasksP.primerLabs.laba2.FractionNumberImpl;
import ua.org.oa.evlashdv.lectures.lecture1.testTasksP.primerLabs.laba2.FractionNumberOperationImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();

		Collection<FractionNumber> numbers = new ArrayCollectionImpl<FractionNumber>();
		numbers.add(new FractionNumberImpl(1, 2));
		numbers.add(new FractionNumberImpl(2, 1));
		numbers.add(new FractionNumberImpl(1, 3));

		FractionNumberOperation fno = new FractionNumberOperationImpl();

		FractionNumber fnRes = new FractionNumberImpl(0, 1);

		for (FractionNumber fractionNumber : numbers) {
			fnRes = fno.add(fnRes, fractionNumber);
		}

		System.out.println(fnRes.toStringValue());

		ArrayCollection<Double> arrayCollection = new ArrayCollectionImpl<Double>();
		ArrayIterator<Double> it = (ArrayIterator<Double>) arrayCollection
				.iterator();

		Double[] doubleArray = { 1d, 2d, 3d };

		arrayCollection.add(-doubleArray[0]);
		arrayCollection.add(doubleArray[0]);
		arrayCollection.add(doubleArray[2]);

		boolean ddd = arrayCollection.retainAll(Arrays.asList(doubleArray));

		System.out.println("end");

	}
}
