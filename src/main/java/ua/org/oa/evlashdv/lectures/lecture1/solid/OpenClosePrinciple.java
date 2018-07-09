package ua.org.oa.evlashdv.lectures.lecture1.solid;

public class OpenClosePrinciple {
    public static void main(String[] args) {
        Toyota toyota=new Toyota();
        Celica celica=new Celica();
        workInTaxi(celica);
    }
    static void workInTaxi(Car car){
        car.workInTaxi();
    }
}
interface Car{
    void workInTaxi();
}
class Toyota implements Car{
    void getPasenger(){
        System.out.println("get passengers");
    }

    @Override
    public void workInTaxi() {
        getPasenger();
    }
}
class Celica extends Toyota{
    @Override
    public void workInTaxi() {
        getPasanger();
    }

    void getPasanger(){
        System.out.println("get passengers");
    }
}