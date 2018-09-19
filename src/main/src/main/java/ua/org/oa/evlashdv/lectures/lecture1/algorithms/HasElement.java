package ua.org.oa.evlashdv.lectures.lecture1.algorithms;

public class HasElement {
    public static void main(String[] args) {
        int[] arr={11,22,33,44,55,66,77,88,99};
        System.out.println(hasElement(arr,11));
    }

    private static boolean hasElement(int[] arr,int element) {
        for (int i=0;i<arr.length;++i){
            if (arr[i]==element) return true;
        }
        return false;
    }
}
