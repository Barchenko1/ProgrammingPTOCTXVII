package ua.org.oa.evlashdv.lectures.lecture1.lecture7b;

public class AutoRunThread extends Thread{
    public AutoRunThread() {
        start();
    }
    @Override
    public void run(){
        System.out.println("Start Thread name= "+getName());
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+" -+ "+i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println("End Thread name= "+getName());
    }
}
