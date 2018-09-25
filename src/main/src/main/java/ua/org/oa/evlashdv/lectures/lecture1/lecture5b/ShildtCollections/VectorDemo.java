package ua.org.oa.evlashdv.lectures.lecture1.lecture5b.ShildtCollections;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer>v= new Vector<>(3,2);
        System.out.println("размер ветора "+v.size());
        System.out.println("начальная емкость "+v.capacity());
        v.addElement(1);
        v.addElement(2);
        v.addElement(3);
        v.addElement(4);
        System.out.println("емкость после ввода 4-х элементов "+v.capacity());
        v.addElement(5);
        System.out.println("текущяя емкость "+v.capacity());
        v.addElement(6);
        v.addElement(7);
        System.out.println("текущяя емкость "+v.capacity());
        v.addElement(9);
        v.addElement(10);
        System.out.println("текущяя емкость "+v.capacity());
        v.addElement(11);
        v.addElement(12);
        System.out.println("первый эл "+v.firstElement());
        System.out.println("последний эл "+v.lastElement());
        if (v.contains(3)) System.out.println("вектор содержит 3");
        Enumeration<Integer>vEmum=v.elements();
        System.out.println("\nЭлементы ветора");
        while (vEmum.hasMoreElements()){
            System.out.print(vEmum.nextElement()+" ");
        }
        System.out.println();
    }
}
