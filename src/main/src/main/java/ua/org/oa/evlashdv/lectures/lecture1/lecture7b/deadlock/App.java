package ua.org.oa.evlashdv.lectures.lecture1.lecture7b.deadlock;

public class App {
    public static void main(String[] args) {
        Human human1=new Human("Vasya",new Phone(),null);
        Human human2=new Human("Sveta",new Phone(),human1);
        human1.setFrined(human2);
        human1.start();
        human2.start();
    }
}
