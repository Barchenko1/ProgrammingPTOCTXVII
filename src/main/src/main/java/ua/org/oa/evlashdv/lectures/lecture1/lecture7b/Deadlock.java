package ua.org.oa.evlashdv.lectures.lecture1.lecture7b;
class A{
    synchronized void foo(B b){
        String name=Thread.currentThread().getName();
        System.out.println(name+" вошел в метод A.foo()");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" пытаюсь войти в метод B.last");
        b.last();
    }
    synchronized void last(){
        System.out.println("В методе А.last()");
    }
}
class B{
    synchronized void foo(A a){
        String name=Thread.currentThread().getName();
        System.out.println(name+" вошел в метод B.foo()");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" пытаюсь войти в метод A.last");
        a.last();
    }
    synchronized void last(){
        System.out.println("В методе B.last()");
    }
}
public class Deadlock implements Runnable {
    A a = new A();
    B b = new B();

    public Deadlock() {
        Thread.currentThread().setName("Главный поток");
        Thread t=new Thread(this,"Соперничающий поток");

        t.start();
        a.foo(b);
    }
    @Override
    public void run() {
        b.foo(a);
    }

    public static void main(String[] args) {
        new Deadlock();
    }

}
