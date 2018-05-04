package ua.org.oa.evlashdv.lectures.lecture1.p1;
class A1{
    String name="A";
    void over(){
        System.out.println("over A");
    }
    void metA(){
        System.out.println("metA");
    }
}
class B extends A1{
    String name="B";
    @Override
    void over(){
        System.out.println("over B");
    }
    void metB(){
        System.out.println("metB");
    }
}
public class ABC {
    public static void main(String[] args) {
        A1 ab=new B();
        A1 a=new A1();
        B b=new B();
        ab.over();
        System.out.println(ab.name);
    }
}
