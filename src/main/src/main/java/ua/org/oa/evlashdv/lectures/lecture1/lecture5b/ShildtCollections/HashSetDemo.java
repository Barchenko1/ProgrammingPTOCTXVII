package ua.org.oa.evlashdv.lectures.lecture1.lecture5b.ShildtCollections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashSetDemo {

    public static void main(String[] args) {
        HashSet<String >hs=new HashSet<>();
        hs.add("Бета");
        hs.add("Альфа");
        hs.add("Эта");
        hs.add("Гамма");
        hs.add("Эпсилон");
        hs.add("Омега");

        System.out.println(hs);
        Object[] st =hs.toArray();
        for (int i = 0; i < st.length; i++) {
            System.out.println(st[i].hashCode());
        }
        LinkedHashSet<String >lhs=new LinkedHashSet<>();
        lhs.add("Бета");
        lhs.add("Альфа");
        lhs.add("Эта");
        lhs.add("Гамма");
        lhs.add("Эпсилон");
        lhs.add("Омега");
        System.out.println(lhs);
    }
}
