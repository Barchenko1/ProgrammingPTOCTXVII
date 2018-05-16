package ua.org.oa.evlashdv.lectures.lecture1.net;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread {
    private PrintStream os;
    private BufferedReader is;
    private InetAddress addr;

    ServerThread(Socket s) throws IOException {
        os=new PrintStream(s.getOutputStream());
        is=new BufferedReader(new InputStreamReader(s.getInputStream()));
        addr=s.getInetAddress();
    }
    public void run(){
        int i=0;
        String str;
        try {
            while ((str=is.readLine())!=null){
                if ("PING".equals(str)){
                    os.println("PONG "+ ++i);
                    System.out.println("PING-PONG"+i+" with "+addr.getHostName());
                }
            }
        } catch (IOException e) {
            System.out.println("Disconnect");
        }finally {
            disconnect();
        }
    }
    void disconnect(){
        try {
            System.out.println(addr.getHostName()+" disconnected");
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            this.interrupt();
        }
    }
}
