package ua.org.oa.evlashdv.lectures.lecture1.lecture5b.ShildtCollections;

import java.util.Properties;
import java.util.Set;

public class PropDemo {
    public static void main(String[] args) {
        Properties defList=new Properties();
        defList.put("Флорида","Тэлесси");
        Properties capitals=new Properties();
        capitals.put("Иллинойс","Спрингфилд");
        capitals.put("Миссури","Джефферсон-Сити");
        capitals.put("Вашингтон", "Олмпия");
        Set<?> states=capitals.keySet();
        for (Object name:states) {
            System.out.println("Столица штата "+name+" - "+capitals.getProperty((String) name)+".");

        }
        System.out.println();
        String str=capitals.getProperty("Флорида");
        System.out.println("столица штата флорида "+str+".");
    }
}
