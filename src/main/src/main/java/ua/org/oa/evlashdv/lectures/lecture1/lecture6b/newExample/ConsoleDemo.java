package ua.org.oa.evlashdv.lectures.lecture1.lecture6b.newExample;

import java.io.*;

public class ConsoleDemo {
    public static void main(String[] args) {
        String str;
        Console con;

        con=System.console();
        if (con==null) return;
        str=con.readLine("Введите строку: ");
        con.printf("Введенная вами строка: %s\n",str);
    }
}
