package ua.org.oa.evlashdv.lectures.lecture1.langEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        int i;
        int sum=0;
        System.out.println("введите 0-для выхода");
        do {
            str=br.readLine();
            try {
                i=Integer.parseInt(str);
            }catch (NumberFormatException e){
                System.out.println("неверный формат");
                i=0;
            }
            sum+=i;
            System.out.println("Текущая сумма "+sum);
        }while (i!=0);
    }
}
