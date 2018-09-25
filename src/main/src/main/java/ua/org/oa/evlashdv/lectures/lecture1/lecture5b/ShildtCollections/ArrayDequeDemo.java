package ua.org.oa.evlashdv.lectures.lecture1.lecture5b.ShildtCollections;

import java.util.ArrayDeque;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        ArrayDeque<String > adq=new ArrayDeque<>();
        adq.push("A");
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");
        System.out.println("Извлечение из очереди");
        while (adq.peek()!=null){
            System.out.print(adq.pop()+" ");
        }
    }
}
