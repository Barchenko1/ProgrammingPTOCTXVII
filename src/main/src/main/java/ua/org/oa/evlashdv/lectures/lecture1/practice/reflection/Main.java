package ua.org.oa.evlashdv.lectures.lecture1.practice.reflection;

import javassist.Modifier;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) throws Exception {
        SomeClass someClass=new SomeClass();
        Class c=someClass.getClass();

        SomeClass someClass1= (SomeClass)c.newInstance();
        Constructor[] constructors=c.getDeclaredConstructors();
        for (Constructor constructor:constructors) {
            System.out.println(constructor.getName());
            Parameter[]parameters=constructor.getParameters();
            for (Parameter parameter:parameters){
                System.out.println(parameter.getName());
                System.out.println(parameter.getType().getName());
            }
        }
        System.out.println("Methods");
        Method[]methods=c.getDeclaredMethods();
        for (Method method:methods){
            System.out.println(method.getName());
            Parameter[] parameters=method.getParameters();
            for (Parameter parameter:parameters){
                System.out.println(parameter.getName());
                System.out.println(parameter.getType().getName());
            }
            System.out.println(Modifier.toString(method.getModifiers()));
        }
        System.out.println("fields");
        Field[] fields=c.getDeclaredFields();
        for (Field field:fields) {
            System.out.println(field.getName());
            System.out.println(field.getType().getName());
            System.out.println(Modifier.toString(field.getModifiers()));
            field.setAccessible(true);
            System.out.println(field.getInt(someClass));
            field.setInt(someClass,5);
            System.out.println(field.getInt(someClass));
        }
    }
}
class SomeClass{
    private int i;
    String s;

    public SomeClass() {
    }

    public SomeClass(String s) {
        this.s = s;
    }
    public String someMethod(String s){
        return "this is"+s;
    }
}
