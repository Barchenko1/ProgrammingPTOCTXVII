package ua.org.oa.evlashdv.lectures.lecture1.lecture4b.Shildt;
class TwoGen<T,V>{
    T ob1;
    V ob2;

    public TwoGen(T ob1, V ob2) {
        this.ob1 = ob1;
        this.ob2 = ob2;
    }
    void showType(){
        System.out.println("Тип Т "+ob1.getClass().getName());
        System.out.println("Тип V "+ob2.getClass().getName());
    }

    public T getOb1() {
        return ob1;
    }

    public V getOb2() {
        return ob2;
    }
}
public class SimpGen {
    public static void main(String[] args) {
        TwoGen<Integer,String >tgObj=new TwoGen<>(88,"Обобение");
        tgObj.showType();
        int v=tgObj.getOb1();
        String str=tgObj.getOb2();
        System.out.println("Значение "+v);
        System.out.println("Значение "+str);
    }
}
