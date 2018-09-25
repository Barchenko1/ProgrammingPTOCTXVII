package ua.org.oa.evlashdv.lectures.lecture1.http.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Client side");

        Socket fromserver = null;


        fromserver = new Socket("192.168.1.159",4444);

        String hello = "Hello World! exit";

        fromserver.getOutputStream().write(hello.getBytes());

        BufferedReader in  = new
                BufferedReader(new
                InputStreamReader(fromserver.getInputStream()));

        PrintWriter out = new
                PrintWriter(fromserver.getOutputStream(),true);
        BufferedReader inu = new
                BufferedReader(new InputStreamReader(System.in));

        String fuser,fserver;

        while ((fuser = inu.readLine())!=null) {
            if (fuser.equalsIgnoreCase("break")||fuser.equalsIgnoreCase("exit")||
                    fuser.equalsIgnoreCase("close"))break;
            out.println(fuser);
            fserver = in.readLine();

            if (fuser.equalsIgnoreCase("break")||fuser.equalsIgnoreCase("exit")||
                    fuser.equalsIgnoreCase("close"))break;
            System.out.println(fserver);
        }

        out.close();
        in.close();
        inu.close();
        fromserver.close();
    }
}