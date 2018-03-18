package ua.org.oa.evlashdv.lectures.lecture1.practices;

public class MaxElement {
    public static void main(String[] args) {
        int [] arr={140,25,35,41,53,62,71,8,9};
        System.out.println(maxElement(arr));
    }

    private static int maxElement(int[] arr) {
        int currentMax=arr[0];
        if (arr.length>0){
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]>currentMax){
                    currentMax=arr[i];
                }
            }
        }
        return currentMax;
    }
}
