package ua.org.oa.evlashdv.lectures.lecture1.lecture7b;

public class App {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        ThreadGroup threadGroup=new ThreadGroup("My thread group");
        Thread thread0=new MyThread();
        Thread thread1=new MyThread();
        Thread thread2=new Thread(threadGroup,new MyRunnable());
        AutoRun thread3=new AutoRun();
        AutoRunThread thread4=new AutoRunThread();
        Thread demon=new Thread(()->{
            for (int i = 0;; i++) {
                System.out.println("demon + "+i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        demon.setDaemon(true);
        demon.start();
        System.out.println("Before Start");
        System.out.println(thread1.getName()+"-"+thread1.getState());
        thread0.start();
        thread1.start();
        System.out.println(thread1.getName()+"-"+thread1.getState());
        thread2.start();
        System.out.println("After Start");
        System.out.println("active "+threadGroup.activeCount());
        try {
            thread1.join();
            System.out.println(thread4.isInterrupted());
            thread4.interrupt();
            //System.out.println(thread4.interrupted());
            System.out.println(thread4.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getName()+"-"+thread1.getState());
        System.out.println("active "+threadGroup.activeCount());
        System.out.println("All done");

    }
}
