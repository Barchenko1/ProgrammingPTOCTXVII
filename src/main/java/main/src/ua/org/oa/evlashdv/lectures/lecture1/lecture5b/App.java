package ua.org.oa.evlashdv.lectures.lecture1.lecture5b;

import java.util.*;

public class App {
    public static void main(String[] args) {
        List<Human> humanList=new ArrayList<>();
        humanList.add(new Human("Vasya",25));
        humanList.add(new Human("Sveta",20));
        humanList.add(new Human("Misha",30));
        humanList.add(new Human("Kolya",31));

        for (Human human:humanList){
            System.out.println(human);
//            if (human.getName().equals("Vasya")){
//                humanList.remove(human);
//            }
        }
        for (Iterator<Human> iterator = humanList.iterator(); iterator.hasNext();){
            if (iterator.next().getName().equals("Vasya")){
                iterator.remove();
            }
        }
        System.out.println("`````````````````````````````");
        humanList.forEach(System.out::println);
        humanList.removeIf(a->a.getName().equals("Sveta"));
        System.out.println("`````````````````````````````");
        humanList.forEach(System.out::println);
        System.out.println("`````````````````````````````");
        for (ListIterator<Human> iterator = humanList.listIterator(humanList.size()); iterator.hasPrevious();){
            System.out.println(iterator.previous());
        }
        Collections.sort(humanList);
        System.out.println("`````````````````````````````");
        humanList.forEach(System.out::println);
        Collections.sort(humanList,Comparator.comparingInt(Human::getAge).reversed());
        System.out.println("`````````````````````````````");
        humanList.forEach(System.out::println);

        Set<Human> humanSet=new HashSet<>();
        humanSet.add(new Human("Vasya",25));
        humanSet.add(new Human("Sveta",20));
        humanSet.add(new Human("Misha",30));
        humanSet.add(new Human("Kolya",31));
        humanSet.add(new Human("Kolya",31));
        humanSet.add(new Human("Kolya",31));
        System.out.println("`````````````````````````````");
        humanSet.forEach(System.out::println);

        System.out.println(new Human("Vasya", 25).hashCode());

        Set<Human>humanSet1=new TreeSet<>(humanSet);
        System.out.println("`````````````````````````````");
        humanSet1.forEach(System.out::println);

        Map<String,Human>humanMap=new HashMap<>();
        for (Human human:humanSet1){
            humanMap.put(human.getName(),human);

        }
        humanMap.entrySet().forEach(a->System.out.println(a.getKey()+" -> "+a.getValue()));

    }
}
