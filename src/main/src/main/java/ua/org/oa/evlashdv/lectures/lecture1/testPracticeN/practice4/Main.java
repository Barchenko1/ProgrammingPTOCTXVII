package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice4;

import interfaces.task4.CollectionUtils;
import interfaces.task4.MapUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(5);
        a.add(10);
        a.add(11);
        a.add(12);
        List<Integer> b = new ArrayList<>();
        b.add(11);
        b.add(1);
        b.add(2);
        b.add(4);
        b.add(6);
        b.add(5);
        b.add(7);
        b.add(9);
        CollectionUtils collectionUtils = new CollectionUtilsImpl();
        System.out.println(collectionUtils.union(a, b));
        System.out.println(collectionUtils.intersectionWithoutDuplicate(a,b));
        System.out.println(collectionUtils.intersection(a,b));
        System.out.println(collectionUtils.difference(a,b));
        System.out.println("/////////////");
        MapUtils mapUtils = new MapUtilsImpl();
        System.out.println(mapUtils.findThrees("1234 345_23345"));
    }
}
