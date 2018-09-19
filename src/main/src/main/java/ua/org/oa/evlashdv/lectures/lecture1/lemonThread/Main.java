package ua.org.oa.evlashdv.lectures.lecture1.lemonThread;

class LemonRun implements Runnable{

    @Override
    public void run() {
        System.out.println("Lemon run!!");
    }
}

class LemonRunThread extends Thread{
    private String threadName;
    public LemonRunThread(String threadName){
        this.threadName=threadName;
    }
    public void run(){
        System.out.println(threadName);
    }
}

public class Main {
    public static void main(String[] args) {
        final long before = System.currentTimeMillis();
        LemonRun lemonRun=new LemonRun();
        Thread thread=new Thread(lemonRun);

        final long after=System.currentTimeMillis();
        System.out.println("Time delta : %d "+(after-before)/1000);

    }
}