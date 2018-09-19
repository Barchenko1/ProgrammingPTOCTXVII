package ua.org.oa.evlashdv.lectures.lecture1.lecture4b.Shildt;
class Gent<T>{
    T ob;

    public Gent(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
}
public class RewDemo {
    public static void main(String[] args) {
        Gent<Integer> iob=new Gent<>(88);
        Gent<String > strob=new Gent<>("Текст");
        Gent raw=new Gent(new Double(98.6));
        double d= (double) raw.getOb();
        System.out.println(d);
//        int i= (int) raw.getOb();
//        System.out.println(i);
        strob=raw;
//        String str=strob.getOb();
        raw=iob;
//        d= (double) raw.getOb();
    }
}
