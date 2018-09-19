package ua.org.oa.evlashdv.lectures.lecture1.lecture7b;

public class TestThread implements Runnable {
    String name;
    Thread t;
    TestThread(String threadname){
        name=threadname;
        t=new Thread(this, name);
        System.out.println("Новый поток "+t);
        t.start();
    }
    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name+" :"+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" Завершен");
    }

    public static void main(String[] args) {
        TestThread ob1=new TestThread("Один");
        TestThread ob2=new TestThread("Два");
        TestThread ob3=new TestThread("Три");
        ob1.t.setPriority(4);
        System.out.println("Приоритет: "+ob1.t.getPriority());
        System.out.println("Поток один запущен: "+ob1.t.isAlive());
        System.out.println("Поток два запущен: "+ob2.t.isAlive());
        System.out.println("Поток три запущен: "+ob3.t.isAlive());
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Поток один запущен: "+ob1.t.isAlive());
        System.out.println("Поток два запущен: "+ob2.t.isAlive());
        System.out.println("Поток три запущен: "+ob3.t.isAlive());
        System.out.println("Главный поток завершен");
    }
}
