package ua.org.oa.evlashdv.lectures.lecture1.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServerThread {
    public static void main(String[] args) {
        try {
            ServerSocket serv=new ServerSocket(8071);
            System.out.println("initialized");
            while (true){
                Socket sock=serv.accept();
                System.out.println(sock.getInetAddress().getHostName()+" connected");
                ServerThread server=new ServerThread(sock);
                server.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
