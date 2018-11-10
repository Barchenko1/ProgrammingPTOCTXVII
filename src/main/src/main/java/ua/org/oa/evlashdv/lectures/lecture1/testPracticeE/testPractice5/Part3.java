package ua.org.oa.evlashdv.lectures.lecture1.testPracticeE.testPractice5;

public class Part3 {
    /**
     * Creates and launches several identical threads
     *
     * @param args
     *            command line parameter
     * @throws InterruptedException
     *             if thread is sleeping and the thread is interrupted, either
     *             before or during the activity
     */
    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter();
        Thread thread1=new MyThread(counter);
        Thread thread2=new MyThread(counter);
        Thread thread3=new MyThread(counter);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

        Counter counter2=new Counter();
        Thread thread4=new MyThreadSynchronized(counter2);
        Thread thread5=new MyThreadSynchronized(counter2);
        Thread thread6=new MyThreadSynchronized(counter2);
        thread4.start();
        thread5.start();
        thread6.start();
        thread4.join();
        thread5.join();
        thread6.join();
    }
    /**
     * The class that stores the counters.
     *
     * @author Barchenko Pavel
     * @version 1.0
     */
    private static class Counter{
        private int counter1;
        private int counter2;

        public int getCounter1() {
            return counter1;
        }

        public int getCounter2() {
            return counter2;
        }

        public void incrementCounter1() {
            counter1++;
        }

        public void incrementCounter2() {
            counter2++;
        }
    }
    /**
     * Class without synchronized block.
     *
     * @author Barchenko Pavel
     * @version 1.0
     */
    private static class MyThread extends Thread{
        Counter counter;
        /**
         * Initializes class fields
         *
         * @param counter
         *            counter
         */
        public MyThread(Counter counter) {
            this.counter = counter;
        }
        public void run() {
            for(int i=0;i<10;i++) {
                System.out.println(Thread.currentThread().getName()+(counter.getCounter1()==counter.getCounter2()));
                counter.incrementCounter1();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.incrementCounter2();
            }
        }
    }
    /**
     * Class with synchronized block.
     *
     * @author Barchenko Pavel
     * @version 1.0
     */
    private static class MyThreadSynchronized extends Thread{
        Counter counter;
        /**
         * Initializes class fields
         *
         * @param counter
         *            counter
         */
        public MyThreadSynchronized(Counter counter) {
            this.counter = counter;
        }
        public void run() {
            synchronized(counter) {
                for(int i=0;i<5;i++) {
                    System.out.println(Thread.currentThread().getName()+(counter.getCounter1()==counter.getCounter2()));
                    counter.incrementCounter1();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    counter.incrementCounter2();
                }
            }
        }
    }
}
