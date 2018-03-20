package ua.org.oa.evlashdv.lectures.lecture1.practices;

import java.util.Arrays;

public class BubbleSortGC {
    public static void main(String[] args) {
        int[] arr={1,3,5,4,5,2,7,10,9};
        for (int barrier = arr.length-1; barrier >= 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (arr[index]>arr[index+1]){
                    swap(arr, index);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int index) {
        int temp=arr[index];
        arr[index]=arr[index+1];
        arr[index+1]=temp;
    }
}
