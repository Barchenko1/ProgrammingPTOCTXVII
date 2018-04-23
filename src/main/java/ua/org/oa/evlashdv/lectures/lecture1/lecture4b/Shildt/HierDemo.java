package ua.org.oa.evlashdv.lectures.lecture1.lecture4b.Shildt;
class Gen1<T>{
    T ob;

    public Gen1(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
}
class Gen2<T,V> extends Gen1<T>{
    V ob2;

    public Gen2(T ob, V ob2) {
        super(ob);
        this.ob2 = ob2;
    }

    public V getOb2() {
        return ob2;
    }
}
public class HierDemo {
    public static void main(String[] args) {
        Gen2<String,Integer> x=new Gen2<>("значение равно: ",99);
        System.out.println(x.getOb());
        System.out.println(x.getOb2());
    }
}
