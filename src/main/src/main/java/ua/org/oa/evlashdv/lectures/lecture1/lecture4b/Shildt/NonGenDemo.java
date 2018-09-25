package ua.org.oa.evlashdv.lectures.lecture1.lecture4b.Shildt;
class NonGen{
    Object ob;

    public NonGen(Object ob) {
        this.ob = ob;
    }

    public Object getOb() {
        return ob;
    }
    void showType(){
        System.out.println("Обьект ob относится к типу "+ob.getClass().getName());
    }
}
public class NonGenDemo {
    public static void main(String[] args) {
        NonGen iOb=new NonGen(88);
        iOb.showType();
        int v= (int) iOb.getOb();
        System.out.println("Значение: "+v);
        NonGen strOb=new NonGen("Тест без обобщиния");
        strOb.showType();
        String str= (String) strOb.getOb();
        System.out.println("Значение: "+str);
        iOb=strOb;
        v= (int) iOb.getOb();
    }
}
