package ua.org.oa.evlashdv.lectures.lecture1.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class MainSocket {
    public static void main(String[] args) {
        try (Socket socket=new Socket();){
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(),8189));
            Scanner scanner=new Scanner(socket.getInputStream());
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
