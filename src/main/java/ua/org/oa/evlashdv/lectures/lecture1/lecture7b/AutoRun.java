package ua.org.oa.evlashdv.lectures.lecture1.lecture7b;

public class AutoRun implements Runnable{

    public AutoRun() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        Thread thread=Thread.currentThread();
        System.out.println("Start Thread name- "+thread.getName());
        for (int i = 0; i < 10; i++) {
            System.out.println(thread.getName()+" +- "+i);
            try {
                thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }System.out.println("End Thread name- "+thread.getName());
    }
}

