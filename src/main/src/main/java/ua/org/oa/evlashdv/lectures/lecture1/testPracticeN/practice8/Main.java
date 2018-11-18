package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice8;

import interfaces.task8.CyclicCollection;
import interfaces.task8.CyclicItem;
import interfaces.task8.PathClassLoader;
import interfaces.task8.SerializableUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        String fileName = "testSerialize.txt";
        OutputStream out = null;
        try {
            out = new FileOutputStream(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream in = null;
        try {
            in = new FileInputStream(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CyclicCollection collection = new CyclicCollectionImpl();

        for (int i = 1; i < 5; i++) {
            collection.add(new CyclicItemImpl("Name" + i,"save " + i));
        }
        CyclicItem ci = collection.getFirst();
        for (int i = collection.size(); i > 0; i--) {
            System.out.println(ci);
            ci = ci.nextItem();
        }
        SerializableUtils serializableUtils = new SerializableUtilsImpl();
        System.out.println(collection);
        System.out.println("after serialize");
        serializableUtils.serialize(out,collection);

        CyclicCollection deserializeCollection =
                (CyclicCollection) serializableUtils.deserialize(in);

        CyclicItem dci = deserializeCollection.getFirst();
        for (int i = deserializeCollection.size(); i > 0; i--) {
            System.out.println(dci);
            dci = dci.nextItem();
        }

        System.out.println(deserializeCollection);
        System.out.println("collections == "
                + (collection == deserializeCollection));
        System.out.println("collections equals "
                + (collection.equals(deserializeCollection)));

        /////////////////// D

        CyclicItem item1 = new CyclicItemImpl("1","1");
        String name = "taskD.txt";
        OutputStream outItemSt = null;
        try {
            outItemSt = new FileOutputStream(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        serializableUtils.serialize(outItemSt,item1);
        InputStream inItemSt1 = null;
        try {
            inItemSt1 = new FileInputStream(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CyclicItem cyclicItem1 =
                (CyclicItem) serializableUtils.deserialize(inItemSt1);
        InputStream inItemSt2 = null;
        try {
            inItemSt2 = new FileInputStream(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        CyclicItem cyclicItem2 =
                (CyclicItem) serializableUtils.deserialize(inItemSt2);
        System.out.println("items == " + (cyclicItem1 == cyclicItem2));
        System.out.println("cyclicItem1 " + cyclicItem1);
        System.out.println("cyclicItem2 " + cyclicItem2);


        /////////////////////

        PathClassLoader pcl = new PathClassLoaderImpl();
        //pcl.setPath("asfdsaf");

        ClassLoader cl = (ClassLoader) pcl;
        Class<?> c = null;
        try {
            c = cl.loadClass(
                    "com.nixsolutions.barchenko.practice1.part1.Matrix");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Object object = null;
        try {
            object = c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(object);
    }
}
