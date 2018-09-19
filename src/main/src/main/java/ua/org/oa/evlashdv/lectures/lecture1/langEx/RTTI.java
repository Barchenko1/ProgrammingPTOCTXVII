package ua.org.oa.evlashdv.lectures.lecture1.langEx;
class X{
    int a;
    float b;
}
class Y extends X{
    double c;
}
public class RTTI {
    public static void main(String[] args) {
        X x=new X();
        Y y=new Y();
        Class clObj;
        clObj=x.getClass();
        System.out.println("x-обьект типа "+clObj.getName());

        clObj=y.getClass();
        System.out.println("y-обьект типа "+clObj.getName());

        clObj=clObj.getSuperclass();
        System.out.println("супер класс у "+clObj.getName());
    }
}
