package ua.org.oa.evlashdv.lectures.lecture1.lemonThread;

public class SimpleThread extends Thread {
    private static int threadCount = 0;
    private int countDown = 5, threadNum = ++threadCount;
    public SimpleThread() {
        System.out.println("Making " + threadNum);
    }
    public void run() {
        while(true) {
            System.out.println("Thread " +         threadNum + "(" + countDown + ")");
            if(--countDown == 0) return;
        }
    }
    public static void main(String[] args) {
        final long before = System.currentTimeMillis();
        for (int i=0;i<5;i++){
            new LemonRunThread("").start();
        }
        System.out.println("All Threads Started");
        System.out.println("All Threads Done");
        final long after=System.currentTimeMillis();
        System.out.println("Time delta : %d "+(after-before)/1000);
    }
}
