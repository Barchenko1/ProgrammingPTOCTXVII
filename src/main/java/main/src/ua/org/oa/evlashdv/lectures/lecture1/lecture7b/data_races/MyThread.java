package ua.org.oa.evlashdv.lectures.lecture1.lecture7b.data_races;

public class MyThread extends Thread {
    @Override
    public void run(){
        increaseCounter();
        increaseCounter();
        increaseCounter();
    }

    private void increaseCounter() {
        synchronized (Count.class){Count.counter++;
        System.out.println(Count.counter);}
    }
}
