package ua.org.oa.evlashdv.lectures.lecture1.p1;

public class Rector {
    // инициализированная константа
    final int ID = (int)(Math.random()*10);
    // неинициализированная константа
    final String NAME_RECTOR;
    public Rector() {
// инициализация в конструкторе
        NAME_RECTOR = "Старый";// только один раз!!!
    }
    // {NAME_RECTOR = "Новый";} // только один раз!!!
    public final void jobRector() {
// реализация
// ID = 100; //ошибка!
    }
    public boolean checkRights(final int num) {
// id = 1; //ошибка!
        final int CODE = 72173394;
        if (CODE == num) return true;
        else return false;
    }
    public static void main(String[] args) {
        System.out.println(new Rector().ID);
    }
}
