package ua.org.oa.evlashdv.lectures.lecture1.practices;

import java.util.Arrays;

public class NotInPlaseArray {
    public static void main(String[] args) {
        int[] array0={1,2,3,4,5,6,7,8,9};
        int[] array1=new int[array0.length];
        for (int i = 0; i <array0.length ; i++) {
            array1[array0.length-i]=array0[i];
        }
        System.out.println(Arrays.toString(array1));
    }
}
