package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice7;

import interfaces.task7.simple.NamePrinterRunnable;

import java.io.PrintStream;

public class NamePrinterRunnableImpl implements NamePrinterRunnable {

    private int count = 0;
    private long interval = 0;
    private String name;
    private PrintStream stream;

    @Override
    public void setPrintName(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        if (name.length() == 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public void setStream(PrintStream stream) {
        if (stream == null) {
            throw new NullPointerException();
        }
        this.stream = stream;
    }

    @Override
    public void setInterval(long ms) {
        if (ms <= 0) {
            throw new IllegalArgumentException();
        }
        this.interval = ms;
    }

    @Override
    public void setCount(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.count = i;
    }

    @Override
    public void run() {
        synchronized (stream) {
            for (int i = count; i > 0; i--) {
                stream.print(name);
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
