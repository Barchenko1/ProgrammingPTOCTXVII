package ua.org.oa.evlashdv.lectures.lecture1.practice.perfumery;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("children thread");
            Thread.yield();
        }
    }
}
