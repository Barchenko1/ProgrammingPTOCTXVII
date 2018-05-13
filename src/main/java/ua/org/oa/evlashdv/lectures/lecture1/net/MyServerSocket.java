package ua.org.oa.evlashdv.lectures.lecture1.net;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {
    public static void main(String[] args) {
        Socket s=null;
        try{
            ServerSocket server=new ServerSocket(8030);
            s=server.accept();
            PrintStream ps=new PrintStream(s.getOutputStream());
            ps.println("привет!");
            ps.flush();
            ps.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
