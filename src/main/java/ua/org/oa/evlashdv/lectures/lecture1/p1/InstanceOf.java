package ua.org.oa.evlashdv.lectures.lecture1.p1;

class A2{
    int i, j;
}
class B2{
    int i,j;
}
class C2 extends A2{
    int k;
}
class D2 extends A2{
    int k;
}
public class InstanceOf {
    public static void main(String[] args) {
        A2 a=new A2();
        B2 b=new B2();
        C2 c=new C2();
        D2 d=new D2();
        if (a instanceof A2){
            System.out.println("а экземпляр А2");
        }
        if (b instanceof B2){
            System.out.println("b экземпляр B2");
        }
        if (c instanceof C2){
            System.out.println("с экземпляр С2");
        }
        if (c instanceof A2){
            System.out.println("c можно привести A2");
        }
        System.out.println();
        A2 ob;
        ob=d;
        System.out.println("ob теперь ссылается на d");
        if (ob instanceof D2){
            System.out.println("ob экземпляр D2");
        }
        System.out.println();

        ob=c;
        System.out.println("ob теперь ссылается на c");
        if (ob instanceof D2){
            System.out.println("ob можно привести к типу D");
        }else System.out.println("ob нельзя привести к типу D");
        if (ob instanceof A2){
            System.out.println("ob можно привести к типу A");
        }
        System.out.println();
        if (a instanceof Object){
            System.out.println("a можно привести к типу Object");
        }
        if (b instanceof Object){
            System.out.println("b можно привести к типу Object");
        }
        if (c instanceof Object){
            System.out.println("c можно привести к типу Object");
        }
        if (d instanceof Object){
            System.out.println("d можно привести к типу Object");
        }
    }
}
