package ua.org.oa.evlashdv.lectures.lecture1.lecture5b.ShildtCollections;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String > al=new ArrayList<>();
        System.out.println("начальный размер списочного массива al "+al.size());
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1,"A2");
        System.out.println("Размер списочного массива al после "+al.size());
        System.out.println("Содержание списочного массива al "+al);
        al.remove("F");
        al.remove(2);
        System.out.println("Размер списочного массива al после "+al.size());
        System.out.println("Содержание списочного массива al "+al);
    }
}
