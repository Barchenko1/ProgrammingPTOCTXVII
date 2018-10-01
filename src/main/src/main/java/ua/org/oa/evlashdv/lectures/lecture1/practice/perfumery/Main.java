package ua.org.oa.evlashdv.lectures.lecture1.practice.perfumery;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        A a=new A();
        B a1= new B();
        try {
            a1=a.returnA();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Object ob=new Object();

        a.doIt();
        System.out.println(a1);

        MyThread myThread=new MyThread();
        myThread.start();

        B1 b1=new B1();
        try {
            b1.m();
        }catch(Throwable e){
            Throwable course=e.getCause();
            System.out.println(course);
        }

    }
}
class A {
    int i=1;
    static int i1=2;
    void doIt(){
        int i2=i*2;
        int i3=i1*2;
    }
    static void doItStatic(){
        //int i2=i*2; не вызывются из статик методов не статик поля
        int i3=i1*2;
    }

    private B b=new B();

    public B returnA() throws CloneNotSupportedException {
        return (B) b.clone();
    }


    @Override
    public String toString() {
        return "A{" +
                "i=" + i +
                '}';
    }
}
class B implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "B{ }";
    }
}
class A1{
    void m(){}
}
class B1 extends A1{
    @Override
    void m()  {
        try {
            throw new IOException();
        } catch (IOException e) {
            throw new Error(e);
        }
    }

}
