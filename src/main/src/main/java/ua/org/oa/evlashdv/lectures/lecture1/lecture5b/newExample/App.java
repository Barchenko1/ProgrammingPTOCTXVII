package ua.org.oa.evlashdv.lectures.lecture1.lecture5b.newExample;

import ua.org.oa.evlashdv.lectures.lecture1.lecture5b.ShildtCollections.Passport;

import java.util.*;

public class App {
    public static void main(String[] args) {
        List<Human>humanList=new ArrayList<>();
        humanList.add(new Human("Vasya",25));
        humanList.add(new Human("Petya",30));
        humanList.add(new Human("Misha",20));
        humanList.add(new Human("Sveta",40));
//        for (Human human:humanList) {
//            if (human.getName().equals("Petya")){
//                humanList.remove(human);
//            }
//        }
        for (int i = 0; i <humanList.size() ; i++) {
            if (humanList.get(i).getName().equals("Petya")){
                //humanList.remove(i);
            }
        }
        humanList.forEach(System.out::println);
//        for (Iterator<Human> iterator=humanList.iterator();iterator.hasNext();){
//            if (iterator.next().getName().equals("Petya")){
//                iterator.remove();
//            }
//        }
        System.out.println("--------------------");
        humanList.forEach(System.out::println);
        List<Human> humans=new LinkedList<>(humanList);
        for (ListIterator<Human> listIterator = humans.listIterator(); listIterator.hasNext();){
            if (listIterator.next().getName().equals("Vasya")){
                listIterator.add(new Human("Lena",19));
            }
        }
        System.out.println("--------------------");
        humans.forEach(System.out::println);

        Collections.sort(humans);
        System.out.println("--------------------");
        humans.forEach(System.out::println);
        humans.sort(Comparator.comparingInt((a)->a.getAge()));
        System.out.println("--------------------");
        humans.forEach(System.out::println);

        Set<Human> humanSet=new HashSet<>(humanList);
        System.out.println("--------------------");
        humans.forEach(System.out::println);

        Hashtable<String ,Double> ht=new Hashtable<>();
        ht.put("Джон Доу",new Double(3434.34));
        ht.put("Том Смит",new Double(123.22));
        ht.put("Джейн Бейкер",new Double(1378.00));
        Set<Map.Entry<String,Double>>set=ht.entrySet();
        for (Map.Entry<String ,Double>me:set) {
            System.out.print(me.getKey()+": ");
            System.out.print(me.getValue()+" - ");
            System.out.println(me.getValue().hashCode());
        }

        Map<Passport,Human> humanMap=new HashMap<>();
        humanMap.put(new Passport("123","2017"),humanList.get(0));
        humanMap.put(new Passport("123","2017"),humanList.get(1));
        humanMap.put(new Passport("123","2017"),humanList.get(2));
        humanMap.put(new Passport("123","2017"),humanList.get(3));
        humanMap.forEach((k,v)-> System.out.println(k+" -> "+v));
        System.out.println(humanMap.get(new Passport("123", "2017")));
        System.out.println(new Passport("123", "2017").hashCode() & 15);
        System.out.println(new Passport("124", "2017").hashCode() & 15);
        System.out.println(new Passport("123", "2017").hashCode() & 15);
        System.out.println(new Passport("224", "2017").hashCode() & 15);
        System.out.println(new Passport("4", "1").hashCode() & 15);
    }

}
