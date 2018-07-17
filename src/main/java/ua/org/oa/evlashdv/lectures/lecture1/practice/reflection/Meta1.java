package ua.org.oa.evlashdv.lectures.lecture1.practice.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno1{
    String str();
    int val();
}
public class Meta1 {
    @MyAnno1(str="два параметра",val=19)
    public static void myMeth(String str, int i){
        Meta1 ob=new Meta1();
        Class c=ob.getClass();
        try {
            Method m=c.getMethod("myMeth",String.class,int.class);
            MyAnno1 anno=m.getAnnotation(MyAnno1.class);
            System.out.println(anno.str()+" "+anno.val());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        myMeth("test",10);
    }
}
