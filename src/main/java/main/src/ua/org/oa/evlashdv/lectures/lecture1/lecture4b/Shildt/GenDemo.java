package ua.org.oa.evlashdv.lectures.lecture1.lecture4b.Shildt;
class Gen<T>{
    T ob;

    public Gen(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
    void showType(){
        System.out.println("Типом Т являеся "+ob.getClass().getName());
    }
}
public class GenDemo {
    public static void main(String[] args) {
        Gen<Double> iOb=new Gen<>(88.0);
        iOb.showType();
        double v=iOb.getOb();
        System.out.println("значение "+v);
        Gen<String>strOb=new Gen<>("Текст сообщения");
        strOb.showType();
        String str=strOb.getOb();
        System.out.println("значение"+str);
    }
}
