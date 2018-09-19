package ua.org.oa.evlashdv.lectures.lecture1.net;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws MalformedURLException {
        URL hp=new URL("http://www.HerbSchildt.com/Articles");
        System.out.println("протокол "+hp.getProtocol());
        System.out.println("порт "+hp.getPort());
        System.out.println("хост "+hp.getHost());
        System.out.println("файл "+hp.getFile());
        System.out.println("полная форма "+hp.toExternalForm());

    }
}
