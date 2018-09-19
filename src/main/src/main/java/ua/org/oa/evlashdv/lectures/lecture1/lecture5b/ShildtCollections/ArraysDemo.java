package ua.org.oa.evlashdv.lectures.lecture1.lecture5b.ShildtCollections;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Hashtable;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] array=new int[10];
        for (int i = 0; i <10 ; i++) {
            array[i]=-3*i;
        }
        System.out.print("массив ");
        display(array);
        Arrays.sort(array);
        System.out.print("отсортированный ");
        display(array);
        Arrays.fill(array,2,6,-1);
        System.out.print("после метода fill() ");
        display(array);
        Arrays.sort(array);
        System.out.print("повторная сортировка ");
        display(array);
        System.out.print("значения -9 находится на позиции ");
        int index=Arrays.binarySearch(array,-9);
        System.out.println(index);
    }

    static void display(int[] array) {
        for (int i:array) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
