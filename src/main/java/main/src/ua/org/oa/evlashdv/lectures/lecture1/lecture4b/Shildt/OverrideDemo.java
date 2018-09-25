package ua.org.oa.evlashdv.lectures.lecture1.lecture4b.Shildt;
class GenEe1<T>{
    T ob;

    public GenEe1(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        System.out.print("Метод getob из класса GenEe1 ");
        return ob;
    }
}
class GenEe2<T>extends GenEe1<T>{

    public GenEe2(T ob) {
        super(ob);
    }
    T getob(){
        System.out.print("Метод getob из класса GenEe2 ");
        return ob;
    }
}
public class OverrideDemo {
    public static void main(String[] args) {
        GenEe1<Integer> iob=new GenEe1<>(88);
        GenEe2<Integer> io2b=new GenEe2<>(99);
        GenEe2<String > strob2=new GenEe2<>("тест обобщение");
        System.out.println(iob.getOb());
        System.out.println(io2b.getob());
        System.out.println(strob2.getob());
    }
}
