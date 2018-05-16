package ua.org.oa.evlashdv.lectures.lecture1.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;

public class Sender {
    public static void main(String[] args) {
        try {
            byte[] data=new byte[1000];
            DatagramSocket s=new DatagramSocket();
            InetAddress addr=InetAddress.getLocalHost();
            FileInputStream fr=new FileInputStream(new File("byte"));
            DatagramPacket pac;
            while (fr.read(data)!=-1){
                pac = new DatagramPacket(data, data.length, addr, 8033);
                s.send(pac);
            }
            fr.close();
            System.out.println("Файл отправлен");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
