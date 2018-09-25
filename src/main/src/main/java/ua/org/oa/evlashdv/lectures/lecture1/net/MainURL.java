package ua.org.oa.evlashdv.lectures.lecture1.net;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class MainURL {
    public static void main(String[] args) throws IOException {
        URLConnection connection=new URL("http://www.google.com").openConnection();
        Scanner scanner=new Scanner(connection.getInputStream());
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }
}
