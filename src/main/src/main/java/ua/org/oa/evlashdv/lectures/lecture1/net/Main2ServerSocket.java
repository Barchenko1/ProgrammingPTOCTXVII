package ua.org.oa.evlashdv.lectures.lecture1.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main2ServerSocket {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            Socket socket = serverSocket.accept();
            Scanner sc = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            //writer.println("hello");
            while (sc.hasNextLine()){
                String str=sc.nextLine();
                writer.println("you've send "+str);
                System.out.println(str);
                if (str.equals("exit")){
                    break;
                }
            }
        }
    }
}