package ua.org.oa.evlashdv.lectures.lecture1.practice.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno3{
    String str() default "test";
    int val() default 9000;
}

public class Meta3 {
    @MyAnno3()
    public static void myMeth3(){
        Meta3 ob=new Meta3();
        Class c=ob.getClass();
        try {
            Method m=c.getMethod("myMeth3");
            MyAnno3 myAnno3=m.getAnnotation(MyAnno3.class);
            System.out.println(myAnno3.str()+" "+myAnno3.val());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        myMeth3();
    }
}
