package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;
class Base{
    public static void assign() {
        System.out.println( "метод assign() из Base");
    }
}
class Sub extends Base{
    public static void assign() {
        System.out.println( "метод assign() из Sub");
    }
}
public class Runner2 {
    public static void main(String[] args) {
        Base ob1=new Base();
        Base ob2= new Sub();
        Sub ob3=new Sub();
        ob1.assign();
        ob2.assign();
        ob3.assign();
    }

}
