package ua.org.oa.evlashdv.lectures.lecture1.lecture6b.ShildtIO;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CharArrayWriterDemo {
    public static void main(String[] args) {
        CharArrayWriter f=new CharArrayWriter();
        String s="Эти данные должны быть выведены в массив";
        char buf[]=new char[s.length()];
        s.getChars(0,s.length(),buf,0);

        try {
            f.write(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Бyфep в виде символьной строки");
        System.out.println(f.toString());
        System.out.println("В массив");

        char c[]=f.toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
        System.out.println(" \nB поток вывода типа FileWriter() ");
        try (FileWriter f2=new FileWriter("test1")){
            f.writeTo(f2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Уcтaнoвкa в исходное состояние ");
        f.reset();
        for (int i = 0; i <3 ; i++) {
            f.write('X');
        }
        System.out.println(f.toString());
    }
}
