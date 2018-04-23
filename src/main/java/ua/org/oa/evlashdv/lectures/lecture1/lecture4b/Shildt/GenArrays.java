package ua.org.oa.evlashdv.lectures.lecture1.lecture4b.Shildt;
class GenA1<T extends Number>{
    T ob;
    T vals[];

    public GenA1(T ob, T[] vals) {
        this.ob = ob;
        this.vals = vals;
    }
}
public class GenArrays {
    public static void main(String[] args) {
        Integer n[]={1,2,3,4,5};
        GenA1<Integer>iob=new GenA1<>(50,n);
        GenA1<?> gens[]=new GenA1<?>[10];
    }
}
