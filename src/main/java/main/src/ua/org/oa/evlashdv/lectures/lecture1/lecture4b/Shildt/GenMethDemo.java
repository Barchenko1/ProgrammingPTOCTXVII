package ua.org.oa.evlashdv.lectures.lecture1.lecture4b.Shildt;

public class GenMethDemo {
    static <T extends Comparable<T>,V extends T>
    boolean isIn(T x,V[] y){
        for (int i = 0; i <y.length ; i++) {
            if (x.equals(y[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer nums[]={1,2,3,4,5};
        if (isIn(2,nums)) System.out.println("есть число 2 в массиве");
        if (!isIn(7,nums)) System.out.println("7 нет в массиве");
        String str[]={"один","два","три","четыри","пять"};
        if (isIn("два",str)) System.out.println("два есть в массиве str");
        if (!isIn("семь",str)) System.out.println("семь нету в массиве str");

    }
}
