package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Insurance current=new CarInsurance();
        System.out.println("premium: "+current.premium());
        System.out.println("category: "+current.category());
        Collection c=new HashSet();
        print(c);

    }
    public static void print(Collection c){
        System.out.println("Collection");
    }
    public static void print(Set c){
        System.out.println("Set");
    }
    public static void print(HashSet c){
        System.out.println("HashSet");
    }
}
class Insurance{
    public static final  int LOW=100;
    public int premium(){
        return LOW;
    }
    public static String category(){
        return "Insurance";
    }
}
class CarInsurance extends Insurance{
    public static final  int HIGH=200;

    public int premium(){
        return HIGH;
    }

    public static String category(){
        return "Car Insurance";
    }

}