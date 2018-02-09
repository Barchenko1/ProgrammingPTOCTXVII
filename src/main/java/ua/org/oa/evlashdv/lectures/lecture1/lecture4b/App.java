package ua.org.oa.evlashdv.lectures.lecture1.lecture4b;

import java.util.ArrayList;
import java.util.List;

import static ua.org.oa.evlashdv.lectures.lecture1.lecture4b.Sex.*;

public class App {
    public static void main(String[] args) {
        Pair<String ,Integer> stringPair=new Pair<>("Milk",25);
        System.out.println(stringPair.getFirst());
        System.out.println(stringPair);
        Byer<Integer,Sex,Pair<String,Integer>> byer=new Byer<>("Vasya",25,MALE);
        Byer<Integer,Sex,Pair<String,Integer>> byer1=new Byer<>("Sasha",32,FEMALE);
        List<Byer<Integer, Sex, Pair<String, Integer>>> byerList=new ArrayList<>();
        byerList.add(byer);
        String s=byer.<String>printArray(new String[]{"1","3","4","2"});
        System.out.println(s);
        System.out.println(byer.compareByer(byer1));

        Human<String>stringHuman=new Human("Vasya",String.class);

    }
}
