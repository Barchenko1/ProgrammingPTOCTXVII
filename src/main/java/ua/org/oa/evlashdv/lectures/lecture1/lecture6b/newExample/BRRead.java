package ua.org.oa.evlashdv.lectures.lecture1.lecture6b.newExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRRead {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        do{
            c= (char) br.read();
            System.out.println(c);
        } while (c!='q');
    }
}
