package ua.org.oa.evlashdv.lectures.lecture1.lecture4b.Shildt;
class NonGen1{
    int num;

    public NonGen1(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
class GenE1<T> extends NonGen1{
    T ob;

    public GenE1(T ob,int num) {
        super(num);
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
}
public class HierDemo2 {
    public static void main(String[] args) {
        GenE1<String > w=new GenE1<>("Добро пожаловать",47);
        System.out.println(w.getOb());
        System.out.println(w.getNum());
    }
}
