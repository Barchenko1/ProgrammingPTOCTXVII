package ua.org.oa.evlashdv.lectures.lecture1.lecture4b;

import lombok.Getter;

public class Human<T> {
    private String name;
    private Class<T> clazz;
    private T transport;
    @Getter
    private T[] array;

    public Human(String name, Class<T> clazz) {
        this.name = name;
        this.clazz = clazz;
        try {
            transport=(T)clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        array=(T[])new Object[10];
        array[0]=transport;
        for (T t:array
             ) {
            System.out.println(t);

        }

    }
}
