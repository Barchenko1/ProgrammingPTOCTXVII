package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice7;

import interfaces.task7.executor.Executor;
import interfaces.task7.executor.SumTask;
import interfaces.task7.executor.Task;
import interfaces.task7.executor.TasksStorage;
import interfaces.task7.simple.NamePrinterRunnable;
import interfaces.task7.simple.NamePrinterThread;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //task a

        String fileName = "testToTask7.txt";

        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        NamePrinterThread thread1 = new NamePrinterThreadImpl();
        thread1.setCount(5);
        thread1.setInterval(1000);
        thread1.setPrintName("I'm extends thread" + System.lineSeparator());
        thread1.setStream(ps);
        thread1.start();

        NamePrinterRunnable runnable = new NamePrinterRunnableImpl();
        runnable.setCount(5);
        runnable.setInterval(1000);
        runnable.setPrintName("I'm implements Runnable"
                + System.lineSeparator());
        runnable.setStream(ps);
        Thread thread2 = new Thread(runnable);
        thread2.start();

        //task b

        TasksStorage tasksStorage = new TasksStorageImpl();
        for (int i = 0; i < 4; i++) {
            tasksStorage.add(new CopyTaskImpl("sorce" + i + ".txt",
                    "dect" + i + ".txt"));
        }
        SumTask task = new SumTaskImpl();
        long l = 1000000;
        task.setMax(l);
        for (int i = 0; i < 10; i++) {
            tasksStorage.add(task);
        }
        Executor executor1 = new ExecutorImpl();
        executor1.setStorage(tasksStorage);
        executor1.start();
        Executor executor2 = new ExecutorImpl();
        executor2.setStorage(tasksStorage);
        executor2.start();
        Executor executor3 = new ExecutorImpl();
        executor3.setStorage(tasksStorage);
        executor3.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor1.stop();
        executor2.stop();
        executor3.stop();

        System.out.println(task.getResult());

    }
}
