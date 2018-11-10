package ua.org.oa.evlashdv.lectures.lecture1.testPracticeE.testPractice5;

public class Part1 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadA threadA=new MyThreadA();
        Thread threadB=new Thread(new MyThreadB());
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();

    }


    private synchronized static void createThread() {
        for(int i=0;i<4;i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyThreadA extends Thread{
        public void run() {
            createThread();
        }
    }

    private static class MyThreadB implements Runnable{
        @Override
        public void run() {
            createThread();
        }

    }
}
