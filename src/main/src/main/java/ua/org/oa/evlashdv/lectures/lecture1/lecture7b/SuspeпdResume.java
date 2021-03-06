package ua.org.oa.evlashdv.lectures.lecture1.lecture7b;

class NewThread implements Runnable{
    String name;
    Thread t;
    boolean suspendFlag;

    public NewThread(String threadname) {
        name=threadname;
        t=new Thread(this,name);
        System.out.println("Новый поток: "+t);
        suspendFlag=false;
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name+" :"+i);
            Thread.sleep(200);
            synchronized (this){
                while (suspendFlag){
                    wait();
                }
            }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" завершен");
    }
    synchronized void mysuspent(){
        suspendFlag=true;
    }
    synchronized void myresume(){
        suspendFlag=false;
        notify();
    }
}

public class SuspeпdResume {
    public static void main(String[] args) {
        NewThread ob1=new NewThread("Один");
        NewThread ob2=new NewThread("Два");

        try {
            Thread.sleep(1000);
            ob1.mysuspent();
            System.out.println("Приостановка потока Один");
            ob1.myresume();
            System.out.println("Возобновление потока Один");
            ob2.mysuspent();
            System.out.println("Приостановка потока Два");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Возобновление потока Один");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Oжидaниe завершения потоков.");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Главный поток завершен");
    }
}
