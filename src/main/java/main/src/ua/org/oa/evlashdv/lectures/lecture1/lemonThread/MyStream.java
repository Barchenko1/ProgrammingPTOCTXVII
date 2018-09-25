package ua.org.oa.evlashdv.lectures.lecture1.lemonThread;

public class MyStream {
    public static void main(String[] args) {

        for (int i=0;i<10;i++){
        new Stream("1").start();
        }
    }
}

class Stream extends Thread{
    private String threadName;
    public Stream(String threadName){
        this.threadName=threadName;
    }
    public void run(){
        System.out.println(this.getName());
    }
}