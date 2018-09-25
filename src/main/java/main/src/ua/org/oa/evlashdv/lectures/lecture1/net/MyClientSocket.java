package ua.org.oa.evlashdv.lectures.lecture1.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClientSocket {
    public static void main(String[] args) {
        Socket socket=null;
        try {
            socket=new Socket(socket.getLocalAddress(),8030);
            BufferedReader br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg=br.readLine();
            System.out.println(msg);
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
