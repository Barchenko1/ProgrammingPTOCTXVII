package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;

class Protection2 extends Protection {
        Protection2() {
        System.out.println("коструктор унаследованный от другого пакета класса");
        //System.out.println("n "+n);
        //System.out.println("n_priv "+p.n_priv);
        System.out.println("n_prot "+n_prot);
        System.out.println("n_pub "+n_pub);
    }
}
class OtherPackage{
    public OtherPackage() {
        Protection p=new Protection();
        System.out.println("конструктор из другого пакета");
//        System.out.println("n "+p.n);
//        System.out.println("n_priv "+p.n_priv);
//        System.out.println("n_prot "+p.n_prot);
        System.out.println("n_pub "+p.n_pub);
    }
}
public class Demo{
    public static void main(String[] args) {
        Protection2 ob1=new Protection2();
        OtherPackage ob2=new OtherPackage();

    }
}