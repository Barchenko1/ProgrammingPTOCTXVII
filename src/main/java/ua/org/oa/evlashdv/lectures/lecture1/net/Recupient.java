package ua.org.oa.evlashdv.lectures.lecture1.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;

public class Recupient {
    public static void main(String[] args) {
        File file=new File("byte3");
        System.out.println("прием данных");
        try {
            acceptFile(file,8033,1000);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void acceptFile(File file, int port, int pacSize) throws IOException {
        byte[] data=new byte [pacSize];
        DatagramPacket pac=new DatagramPacket(data,data.length);
        DatagramSocket s=new DatagramSocket(port);
        FileOutputStream os =new FileOutputStream(file);
        try {
            s.setSoTimeout(60000);
            while (true){
                s.receive(pac);
                os.write(data);
                os.flush();
            }
        }catch (SocketTimeoutException e){
            os.close();
            System.out.println("истекло время");
        }
    }
}
