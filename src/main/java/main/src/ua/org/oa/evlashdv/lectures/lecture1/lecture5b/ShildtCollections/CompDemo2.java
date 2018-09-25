package ua.org.oa.evlashdv.lectures.lecture1.lecture5b.ShildtCollections;

import java.util.Comparator;
import java.util.TreeSet;

class MyComp1 implements Comparator<String >{

    @Override
    public int compare(String aStr, String bStr) {
        return aStr.compareTo(bStr);
    }
}
public class CompDemo2 {
    public static void main(String[] args) {
        TreeSet<String >ts=new TreeSet<>(new MyComp1());
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
        for (String element :ts) {
            System.out.print(element+" ");
        }

    }
}
