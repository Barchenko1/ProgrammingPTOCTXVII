package ua.org.oa.evlashdv.lectures.lecture1.lecture7b;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Start Thread name- "+getName());
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+" -- "+i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                return;
                //e.printStackTrace();
            }
        }
        System.out.println("End Thread name- "+getName());
    }

}

