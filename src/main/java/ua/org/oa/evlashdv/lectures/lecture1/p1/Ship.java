package ua.org.oa.evlashdv.lectures.lecture1.p1;

public class Ship{
    int size=5;

    public class Engine {
        public void launch(){
            System.out.println("Запуск двигателя");
        }
    }
    interface SwimS{
        void swim();
    }
    public void init(){
        Engine eng=new Engine();
        eng.launch();
    }

    public static void main(String[] args) {
        Ship.Engine obj=new Ship().new Engine();

        System.out.println(obj);
    }
}
class WarShip extends Ship {
    protected class SpacialEngine extends Engine{

    }
    class Motor extends Engine{
        public Motor() {

        }
    }
}

