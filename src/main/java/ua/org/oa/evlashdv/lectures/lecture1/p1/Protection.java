package ua.org.oa.evlashdv.lectures.lecture1.p1;

public class Protection {
    int n=1;
    private int n_priv=2;
    protected int n_prot=3;
    public int n_pub=4;

    public Protection() {
        System.out.println("коструктор базового класса");
        System.out.println("n "+n);
        System.out.println("n_priv "+n_priv);
        System.out.println("n_prot "+n_prot);
        System.out.println("n_pub "+n_pub);
    }

    public static void main(String[] args) {
        Protection ob1=new Protection();
        Derived ob2=new Derived();
        SamePackage ob3=new SamePackage();
    }
}
class Derived extends Protection{
    public Derived() {
        System.out.println("коструктор подкласса");
        System.out.println("n "+n);
        //System.out.println("n_priv "+n_priv);
        System.out.println("n_prot "+n_prot);
        System.out.println("n_pub "+n_pub);
    }
}
class SamePackage{
    public SamePackage() {
        Protection p=new Protection();
        System.out.println("коструктор этого же пакета");
        System.out.println("n "+p.n);
        //System.out.println("n_priv "+p.n_priv);
        System.out.println("n_prot "+p.n_prot);
        System.out.println("n_pub "+p.n_pub);
    }
}

