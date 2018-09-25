package ua.org.oa.evlashdv.lectures.lecture1.net;

import java.io.IOException;
import java.net.*;

public class ReadServer {
    static int serverPort=998;
    static int clientPort=999;
    static int buffer_size=1024;
    static DatagramSocket ds;
    static byte buffer[]=new byte[buffer_size];

    static void TheServer() throws IOException {
        int pos=0;
        while (true){
            int c=System.in.read();
            switch (c){
                case -1:
                    System.out.println("сервер завершает сеанс свзяи");
                    ds.close();
                    return;
                case '\r':break;
                case '\n':ds.send(new DatagramPacket(buffer,pos,InetAddress.getLocalHost(),clientPort));
                    pos=0;
                    break;
                default:buffer[pos++]= (byte) c;
            }
        }
    }
    static void TheClient() throws IOException {
        while (true){
            DatagramPacket p=new DatagramPacket(buffer,buffer.length);
            ds.receive(p);
            System.out.println(new String (p.getData(),0,p.getLength()));
        }
    }

    public static void main(String[] args) throws IOException {
        ds=new DatagramSocket(clientPort);
        TheClient();
    }
}
