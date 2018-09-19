package ua.org.oa.evlashdv.lectures.lecture1.patterns;
class Singleton {
    int i=0;
    static Singleton singleton=new Singleton();

    private Singleton() {
    }
    public static Singleton getInstance(){
        return singleton;
    }
}
public class SingletonLesson {
    public static void main(String[] args) {
        Singleton singleton=Singleton.getInstance();
        Singleton singleton1=Singleton.getInstance();
        singleton1.i=1;
        System.out.println(singleton.i);
    }
}
