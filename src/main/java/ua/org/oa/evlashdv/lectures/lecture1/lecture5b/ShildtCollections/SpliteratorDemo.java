package ua.org.oa.evlashdv.lectures.lecture1.lecture5b.ShildtCollections;

import java.util.ArrayList;
import java.util.Spliterator;

public class SpliteratorDemo {
    public static void main(String[] args) {
        ArrayList<Double>vals=new ArrayList<>();
        vals.add(1.0);
        vals.add(2.0);
        vals.add(3.0);
        vals.add(4.0);
        vals.add(5.0);
        System.out.println("Содержимое списочного массива vals\n");
        Spliterator<Double> spltitr=vals.spliterator();
        while (spltitr.tryAdvance((n)-> System.out.println(n)));
        System.out.println();
        spltitr=vals.spliterator();
        ArrayList<Double>sqrs=new ArrayList<>();
        while (spltitr.tryAdvance((n)-> sqrs.add(Math.sqrt(n))));
        System.out.println("Содержимое списочного массива sqrt\n");
        spltitr=sqrs.spliterator();
        spltitr.forEachRemaining((n)-> System.out.println(n));
        System.out.println();

    }
}
