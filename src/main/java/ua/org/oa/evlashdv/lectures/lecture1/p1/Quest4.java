package ua.org.oa.evlashdv.lectures.lecture1.p1;

class Base1{

    }
class A extends Base1{

}
public class Quest4 {
    public static void main(String[] args) {
Base1 b=new Base1();
A a=new A();
Base1 base=a;
A ob= (A) b;
    }
}


