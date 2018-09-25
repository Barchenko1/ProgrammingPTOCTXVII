package ua.org.oa.evlashdv.lectures.lecture1.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadDocument {
    public static void main(String[] args) throws IOException {
        try { URL lab = new URL("http://www.bsu.by");
            InputStreamReader isr = new InputStreamReader(lab.openStream());
            BufferedReader d = new BufferedReader(isr);
            String line = "";
            while ((line = d.readLine()) != null) {
                System.out.println(line); }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
            catch (IOException e) {
            e.printStackTrace();
        }
    }
}