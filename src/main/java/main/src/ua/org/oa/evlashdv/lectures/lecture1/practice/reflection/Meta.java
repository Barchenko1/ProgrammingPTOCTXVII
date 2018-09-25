package ua.org.oa.evlashdv.lectures.lecture1.practice.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
    String str();
    int val();
}
public class Meta {
    @MyAnno(str="пример анотации",val=100)
    public static void myMeth(){
        Meta ob=new Meta();
        Class c=ob.getClass();
        try {
            Method m=c.getMethod("myMeth");
            MyAnno anno=m.getAnnotation(MyAnno.class);
            System.out.println(anno.str()+" "+anno.val());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        myMeth();
    }
}
