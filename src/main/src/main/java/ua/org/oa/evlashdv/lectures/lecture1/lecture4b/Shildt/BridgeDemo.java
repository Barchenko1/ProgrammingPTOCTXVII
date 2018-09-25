package ua.org.oa.evlashdv.lectures.lecture1.lecture4b.Shildt;
class GenB1<T>{
    T ob;

    public GenB1(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
}
class GenB2 extends GenB1<String >{

    public GenB2(String ob) {
        super(ob);
    }
    String getob(){
        System.out.println("Вызван метод String getob(): ");
        return ob;
    }
}
public class BridgeDemo {
    public static void main(String[] args) {
        GenB2 strob2=new GenB2("ТЕст обобщений");
        System.out.println(strob2.getob());
    }
}
