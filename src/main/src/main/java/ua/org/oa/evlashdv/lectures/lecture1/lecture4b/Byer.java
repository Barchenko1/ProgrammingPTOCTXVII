package ua.org.oa.evlashdv.lectures.lecture1.lecture4b;

import java.util.ArrayList;
import java.util.List;

public class Byer<E extends Number,U,S> {
    private String name;
    private E age;
    private U sex;
    private List<S> basket=new ArrayList<>();

    public int compareByer(Byer<E,U,?> eusByer){
        return Double.compare (age.doubleValue(),eusByer.getAge().doubleValue());
    }

    public <T>String printArray(T[] array){
        StringBuilder sb =new StringBuilder();
        for (T t:array){
            sb.append(t).append("\n");
        }
        return sb.toString();
    }

    public void addToBastek(S stuff){
        basket.add(stuff);
    }
    public S getToBastek (int index){
         return basket.get(index);
    }

    public Byer(String name, E age, U sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public E getAge() {
        return age;
    }

    public void setAge(E age) {
        this.age = age;
    }

    public U getSex() {
        return sex;
    }

    public void setSex(U sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Byer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", basket=" + basket +
                '}';
    }
}
class A{}
class B<T> extends A{}
class C<T,U>extends B<T>{}
class D extends C<Integer,String >{}
