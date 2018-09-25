package ua.org.oa.evlashdv.lectures.lecture1.lecture6b.ShildtIO;

import java.io.*;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        int size;
        try (FileInputStream f=new FileInputStream("FileInputStreamDemo.java")){
            System.out.println("Общее количество доступных байтов: "+(size=f.available()));
            int n=size/40;
            System.out.println("Первый "+n+" байтов, "+"прочитаных из файлов по очереди методом read()");
            for (int i = 0; i <n ; i++) {
                System.out.println((char)f.read());
            }
            System.out.println("\nВсе еще доступно: "+f.available());
            System.out.println("Чтение следующих "+n+" байтов по очереди методом read(b[])");

            byte b[]=new byte[n];
            if (f.read(b)!=n){
                System.err.println("Нельзя прочитать "+n+" байтов.");
            }
            System.out.println(new String (b,0,n));
            System.out.println("\nВсе еще доступно: "+f.available());
            f.skip(size/2);
            System.out.println("Все еще доступно: "+f.available());
            System.out.println("Чтение "+n/2+" байтов, размещаемых в конце массива");
            if (f.read(b,n/2,n/2)!=n/2){
                System.err.println("Нельзя прочитать "+n/2+" байтов.");
            }
            System.out.println(new String (b,0,b.length));
            System.out.println("\nВсе еще доступно: "+f.available());
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода: "+e);
        }
    }
}
