package ua.org.oa.evlashdv.lectures.lecture1.http.client;

import java.net.Socket;

public class SampleClient {
    public static void main(String args[])
    {
        try
        {
            // открываем сокет и коннектимся к localhost:3128
            // получаем сокет сервера
            Socket s = new Socket("localhost", 3128);

            // берём поток вывода и выводим туда первый аргумент
            // заданный при вызове, адрес открытого сокета и его порт
//            args[0] = ""+"\n"+s.getInetAddress().getHostAddress()
//                    +":"+s.getLocalPort();
            String hello = "Hello World!";

            s.getOutputStream().write(hello.getBytes());

            // читаем ответ
            byte buf[] = new byte[64*1024];
            int r = s.getInputStream().read(buf);
            String data = new String(buf, 0, r);

            // выводим ответ в консоль
            System.out.println(data);
        }
        catch(Exception e)
        {System.out.println("init error: "+e);} // вывод исключений
    }
}