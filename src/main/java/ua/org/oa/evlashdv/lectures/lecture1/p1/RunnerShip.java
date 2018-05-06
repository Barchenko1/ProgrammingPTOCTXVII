package ua.org.oa.evlashdv.lectures.lecture1.p1;

class Ship1 {
    private int id;
    public static class LifeBoat{
        public static void down(){
            System.out.println("шлюпки на воду!");
        }
        public void swim() {
            System.out.println("отплытие шлюпки");
        }
    }
}
public class RunnerShip{
    public static void main(String[] args) {
        Ship1.LifeBoat.down();
        Ship1.LifeBoat lf=new Ship1.LifeBoat();
        lf.swim();
    }
}
interface University{
    int NUMBER_FACULTETY=20;
    class LearningDepartment {
        int idChief;

        static void assignPlan(int idFaculty) {

        }

        void acceptProgram() {

        }
    }

}
