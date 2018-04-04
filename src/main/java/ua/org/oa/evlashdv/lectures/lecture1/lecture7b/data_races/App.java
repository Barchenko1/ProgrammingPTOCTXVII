package ua.org.oa.evlashdv.lectures.lecture1.lecture7b.data_races;

public class App {
    public static void main(String[] args) {
        Thread thread1=new MyThread();
        Thread thread2=new MyThread();
        Thread thread3=new MyThread();

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
