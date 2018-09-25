package ua.org.oa.evlashdv.lectures.lecture1.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetLogic {
    public static void main(String[] args) {
        InetAddress myIP=null;
        InetAddress bsuIP=null;
        try {
            myIP=InetAddress.getLocalHost();
            System.out.println("Мой IP -> " + myIP.getHostAddress());
            bsuIP=InetAddress.getByName("www.bsu.by");
            System.out.println("BSU -> " + bsuIP.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
