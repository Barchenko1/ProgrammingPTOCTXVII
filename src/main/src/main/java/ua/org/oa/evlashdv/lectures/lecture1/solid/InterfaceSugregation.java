package ua.org.oa.evlashdv.lectures.lecture1.solid;

public class InterfaceSugregation {
    public static void main(String[] args) {
        IWorker iWorker=new Cooker1();
        iWorker.work();
        iWorker.eat();
    }
}
interface Worker{
    void work();
}
interface Eater{
    void eat();
}
interface IWorker extends Worker,Eater{
    void work();
    void eat();
}
class Cooker1 implements IWorker{

    @Override
    public void work() {
        System.out.println("work");
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }
}
class Waiter implements Worker{

    @Override
    public void work() {
        System.out.println("deliver food");
    }
}