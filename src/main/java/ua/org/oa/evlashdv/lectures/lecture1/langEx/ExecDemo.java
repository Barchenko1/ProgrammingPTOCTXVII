package ua.org.oa.evlashdv.lectures.lecture1.langEx;

import java.io.IOException;

public class ExecDemo {
    public static void main(String[] args) {
        Runtime r=Runtime.getRuntime();
        Process p=null;
        try {
            ProcessBuilder proc=new ProcessBuilder("smile.jpg","testfile");
            proc.start();
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }
}
