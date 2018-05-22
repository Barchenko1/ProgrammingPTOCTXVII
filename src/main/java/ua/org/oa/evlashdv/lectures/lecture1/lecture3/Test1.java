package ua.org.oa.evlashdv.lectures.lecture1.lecture3;




interface Lets{
    static void countLegs(){
        System.out.println(4);
    };
}
class Animal implements Lets{
    private  int x;
    private  int y ;
    static int q;

    public static void eat() {
        System.out.println("eat");

    }

    public static String eat(int i) {
        return "eat2";
    }

    void animalMethod(){
        System.out.println("Animal");
    }
    static interface iHave{
        static void tail(){
            System.out.println("i have a tail");
        }
    }

}
public class Test1 extends Animal{
    String name;
    class Bird{

        void fly(){
            System.out.println("i can fly");
        }
        Bird bird=new Bird();

    }
    void testMethod(){
        System.out.println("test1");
    }
    public static void main(String[] args) {
        Test1 test1=new Test1();
        Test1.eat();
        Test1.eat(1);
        Animal animal=new Animal();
        Animal animal1=new Test1();
        System.out.println(animal.equals(animal1));
        Lets.countLegs();

    }
}
