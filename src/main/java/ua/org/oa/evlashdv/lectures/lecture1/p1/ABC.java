package ua.org.oa.evlashdv.lectures.lecture1.p1;
class A1{
    String name="A";
    void over(){
        System.out.println("over A");
    }
    void metA(){
        System.out.println("metA");
    }
    static class Astat{}
}
class B1 extends A1 implements AB1{
    String name="B";
    @Override
    void over(){
        System.out.println("over B");
    }
    void metB(){
        System.out.println("metB");
    }

    @Override
    public void myName() {
        System.out.println("myName AB1");
    }

}
interface AB1{
    String ab11="AB1";
    void myName();

}
abstract class absAB1 implements AB1{
    @Override
    public void myName(){
        System.out.println("absAB1 met myName");
    }
}
class C extends absAB1{
    @Override
    public void myName(){
        System.out.println("C met myName");
    }
    static int i=1;
    static void statmet(){
        System.out.println(++i);;
    }
}
public class ABC {
    private int count;

    public ABC() {
        count++;
    }
    public void printCount(){
        System.out.println(count);
    }

    public static void main(String[] args) {
        A1 ab=new B1();
        A1 a=new A1();
        B1 b=new B1();
        ab.over();
        System.out.println(ab.name);
        AB1 ab1=new B1();
        ab1.myName();
        System.out.println(AB1.ab11);
        C c=new C();
        c.myName();
        C.statmet();
        ABC abc1=new ABC();
        abc1.printCount();
        ABC abc2=new ABC();
        abc2.printCount();
    }
}
