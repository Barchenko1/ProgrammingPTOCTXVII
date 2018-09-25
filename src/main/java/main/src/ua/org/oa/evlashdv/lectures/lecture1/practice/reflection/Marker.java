package ua.org.oa.evlashdv.lectures.lecture1.practice.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker{}
public class Marker {
    @MyMarker
    public static void myMeth4(){
        Marker ob=new Marker();
        try {
            Method m=ob.getClass().getMethod("myMeth4");
            if (m.isAnnotationPresent(MyMarker.class)){
                System.out.println("Аннотация маркер пристуствует");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        myMeth4();
    }
}
