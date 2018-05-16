package ua.org.oa.evlashdv.lectures.lecture1.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UnCheckedHost {
    public static void main(String[] args) {
        byte ip[]={(byte) 217,(byte)21,(byte)43,(byte)10};
        try {
            InetAddress addr=InetAddress.getByAddress("University",ip);
            System.out.println(addr.getHostName() + "-> cоединение:" + addr.isReachable(1000));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
