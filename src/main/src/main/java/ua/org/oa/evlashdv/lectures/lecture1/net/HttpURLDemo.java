package ua.org.oa.evlashdv.lectures.lecture1.net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLDemo {
    public static void main(String[] args) throws IOException {
        HttpURLConnection hpCon= (HttpURLConnection) new URL("http://www.google.com").openConnection();
        System.out.println("метод запроса "+hpCon.getRequestMethod());
        System.out.println("код ответа запроса "+hpCon.getResponseCode());
        System.out.println("ответное сообщение "+hpCon.getResponseMessage());
        Map<String,List<String>>hdrMap=hpCon.getHeaderFields();
        Set<String> hdrFriend=hdrMap.keySet();
        System.out.println("\nДалее следует заголовок ");
        for (String k:hdrFriend) {
            System.out.println("ключ "+k+" значение "+hdrMap.get(k));
        }
    }
}
