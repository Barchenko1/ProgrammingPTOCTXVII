package ua.org.oa.evlashdv.lectures.lecture1.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetClientThread {
    public static void main(String[] args) {
        try {
            Socket s=new Socket(InetAddress.getLocalHost(),8071);
            PrintStream ps=new PrintStream(s.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            for (int i = 0; i < 10; i++) {
                ps.println("PING");
                System.out.println(br.readLine());
                Thread.sleep(1000);
            }
            s.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
