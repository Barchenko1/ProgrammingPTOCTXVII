package ua.org.oa.evlashdv.lectures.lecture1.lecture5b.ShildtCollections;

import javax.sound.midi.Soundbank;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class AlgorithmsDemo {
    public static void main(String[] args) {
        LinkedList<Integer>ll=new LinkedList<>();
        ll.add(-8);
        ll.add(20);
        ll.add(-20);
        ll.add(8);
        Comparator<Integer>r= Collections.reverseOrder();
        Collections.sort(ll,r);
        System.out.println("Отсортировка в обратном порядке");
        for (int i:ll) {
            System.out.print(i+" ");
        }
        System.out.println();
        Collections.shuffle(ll);
        System.out.println("Список перетасован: ");
        for (int i:ll) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Минимум: "+Collections.min(ll));
        System.out.println("Максимум: "+Collections.max(ll));
    }
}
