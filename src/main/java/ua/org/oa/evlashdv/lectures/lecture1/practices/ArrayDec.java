package ua.org.oa.evlashdv.lectures.lecture1.practices;


import java.util.Arrays;

public class ArrayDec {
    public static void main(String[] args) {
        int [] array={1,2,3,4,5,6,7,8,9};
        for (int i = array.length/2-1; i > -1; i--) {
            int tmp=array[i];
            array[i]=array[array.length-1-i];
            array[array.length-1-i]=tmp;
        }
        System.out.println(Arrays.toString(array));

    }
}
