package ua.org.oa.evlashdv.lectures.lecture1.practice.perfumery;

public class HashTest {
    public static void main(String[] args) {
        A2 o1=new A2();
        A2 o2=new A2();
        o1.setA(1);
        o1.setB(2);
        o2.setA(2);
        o2.setB(1);
        System.out.println(o1.equals(o2));
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
        o2.setA(25);
        o2.setB(100);
        System.out.println(o1.hashCode() == o2.hashCode());
    }
}
class A2{
    private int a;
    private int b;


    @Override
    public int hashCode() {

        return a+b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
