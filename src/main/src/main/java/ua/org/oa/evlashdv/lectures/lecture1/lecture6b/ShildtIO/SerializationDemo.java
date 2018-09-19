package ua.org.oa.evlashdv.lectures.lecture1.lecture6b.ShildtIO;

import ua.org.oa.evlashdv.lectures.lecture1.lecture6b.MyClass;

import java.io.*;
class MyClass1 implements Serializable{
    String  s;
    int i;
    double d;

    public MyClass1(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return "MyClass1{" +
                "s='" + s + '\'' +
                ", i=" + i +
                ", d=" + d +
                '}';
    }
}
public class SerializationDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream objOStrm=new ObjectOutputStream(new FileOutputStream("serial"))){
            MyClass1 object1=new MyClass1("Hello",-7,2.7e10);
            System.out.println("object1: "+object1);
            objOStrm.writeObject(object1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream objIStrm=new ObjectInputStream(new FileInputStream("serial"))){
            MyClass1 object2= (MyClass1) objIStrm.readObject();
            System.out.println("object2: "+object2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
