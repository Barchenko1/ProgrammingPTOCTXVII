package ua.org.oa.evlashdv.lectures.lecture1.lecture7b;

class Callme{
    void call(String msg){
        System.out.print("["+msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("]");
    }
}
class Caller implements Runnable{
    String msg;
    Callme target;
    Thread t;

    public Caller(Callme targ, String  s) {
        msg = s;
        target = targ;
        t=new Thread(this);
        t.start();

    }
    @Override
    public void run() {
        synchronized (target){
       target.call(msg);}
    }
}
public class Synch {
    public static void main(String[] args) {
        Callme target=new Callme();
        Caller ob1=new Caller(target,"Добро пожаловать");
        Caller ob2=new Caller(target,"в синхроницизированный");
        Caller ob3=new Caller(target,"мир!");

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
