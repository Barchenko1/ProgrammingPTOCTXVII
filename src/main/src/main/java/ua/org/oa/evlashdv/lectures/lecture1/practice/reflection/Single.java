package ua.org.oa.evlashdv.lectures.lecture1.practice.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MySingle{
    int value();
}
public class Single {
    @MySingle(100)
    public static void myMeth5(){
        Single ob=new Single();
        try {
            Method m=ob.getClass().getMethod("myMeth5");
            MySingle anno=m.getAnnotation(MySingle.class);
            System.out.println(anno.value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        myMeth5();
    }
}
