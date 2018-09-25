package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;

final class E{
    void fly(){
        System.out.println("E");
    }
}
public class Wrap {
    static String w="Wrap";
    String w1="Wrap2";
    class A {
        String a="A";

    }
    static class B {
        String b="B";
    }
    interface inInterf{
        static void show(){
            Wrap.w="Change by inInterf";
        };
    }
    public static void main(String[] args) {
        Wrap.A a=new Wrap().new A();
        B b=new B();
        Wrap wrap=new Wrap();
        System.out.println(a.a);
        System.out.println(b.b);
        System.out.println(wrap.w);

    }
}
