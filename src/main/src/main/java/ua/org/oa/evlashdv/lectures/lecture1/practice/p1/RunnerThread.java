package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;
class Blocked{
    private int i=1000;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    synchronized void doWait(){
        System.out.print("Не ");
        try {
            this.wait();
            System.out.print("сущностей ");
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int j = 0; j <5 ; j++) {
            System.out.print("сверх ");
        }
    }
}
public class RunnerThread {
    public static void main(String[] args) {
        Blocked lock =new Blocked();
        new Thread(){
            @Override
            public void run() {
                lock.doWait();
            }
        }.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock){
            lock.setI(lock.getI()+3);
            System.out.print("преумножай ");
            lock.notify();
        }
        synchronized (lock){
            lock.setI(lock.getI()+4);
            System.out.print("необходимого. ");
            try {
                lock.wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("="+lock.getI());
    }
}
