package ua.org.oa.evlashdv.lectures.lecture1.p1;

import ua.org.oa.evlashdv.lectures.lecture1.lecture7b.Synch;

import java.io.FileWriter;
import java.io.IOException;

class Synchro{
    private FileWriter fileWriter;

    public Synchro(String  file)throws IOException {
        fileWriter=new FileWriter(file,true);
    }
    void close(){
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    synchronized void writing(String str,int i){
        try {
            System.out.print(str+i);
            fileWriter.append(str+i);
            Thread.sleep((long) (Math.random()*50));
            System.out.print("->" + i + " ");
            fileWriter.append("->" + i + " ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyThread extends Thread{
    private Synchro s;

    public MyThread(String str,Synchro s) {
        super(str);
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            s.writing(getName(),i);
        }
    }
}
public class SynchroThreads {
    public static void main(String[] args) {
        try {
            Synchro s=new Synchro("c:\\temp\\data1.txt");
            MyThread t1 = new MyThread("First", s);
            MyThread t2 = new MyThread("Second", s);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
