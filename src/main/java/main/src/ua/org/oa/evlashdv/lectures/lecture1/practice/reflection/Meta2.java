package ua.org.oa.evlashdv.lectures.lecture1.practice.reflection;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno2{
    String str();
    int val();
}
@Retention(RetentionPolicy.RUNTIME)
@interface What{
    String description();
}
@What(description = "Аннотация тестового класса")
@MyAnno2(str="Meta2",val=99)
public class Meta2 {
    @What(description = "Аннотация тестового метода")
    @MyAnno2(str="Testing",val=100)
    public static void myMeth2(){
        Meta2 ob=new Meta2();
        Annotation[] annos=ob.getClass().getAnnotations();
        System.out.println("все аннотации для класса Meta2:");
        for (Annotation a:annos) {
            System.out.println(a);
        }
        System.out.println();
        try {
            Method m=ob.getClass().getMethod("myMeth2");
            annos=m.getAnnotations();
            System.out.println("все аннотации для метода myMeth2");
            for (Annotation a:annos) {
                System.out.println(a);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        myMeth2();
    }
}
