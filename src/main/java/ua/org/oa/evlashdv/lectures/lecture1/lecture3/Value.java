package ua.org.oa.evlashdv.lectures.lecture1.lecture3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Value {
    public static void main(String[] args) {
        String s1="mama mila ramu";
        String s2="Vasya mil mashitu";

        System.out.println(s1.regionMatches(5,s2,6,3));

        System.out.println(s1.indexOf("mil", 0));

        StringTokenizer st=new StringTokenizer(s2, " ");
        while (st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
        String s3="3 4 5 6, 45 3";
        Scanner sc=new Scanner(s3).useDelimiter(" ");
        while (sc.hasNextInt()){
            System.out.println(sc.nextInt() + 2);
        }
        String [] strings=s3.split("[, ]+");
        System.out.println(Arrays.toString(strings));

        String s="Это демонстрационная строка";
        char buf[]=new char[4];
        s.getChars(4,8,buf,0);
        System.out.println(buf);

        String s4="This is a test";
        System.out.println(s4.substring(0, 4));
        System.out.println(s4.replace('t','w'));

        String res=String.join(" ","Pasha","Barchenko","Vasilevich","Email");
        System.out.println(res);

        StringBuffer sb=new StringBuffer("Hello");
        System.out.println("Буфер= "+sb);
        System.out.println("Длина "+sb.length());
        System.out.println("Емкость "+sb.capacity());
    }
}
