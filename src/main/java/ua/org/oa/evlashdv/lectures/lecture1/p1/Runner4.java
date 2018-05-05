package ua.org.oa.evlashdv.lectures.lecture1.p1;
abstract class AbstractManager {

    public abstract void assignGroupToCourse(
            int groupId, String nameCourse);
}
class CourseManager extends AbstractManager {


    @Override
    public void assignGroupToCourse(int groupId, String nameCourse) {
        System.out.println("группа " + groupId
                + " назначена на курс " + nameCourse);
    }
}
public class Runner4 {
    public static void main(String[] args) {
        AbstractManager mng;
        mng=new CourseManager();
        mng.assignGroupToCourse(10,"Алгебра");
    }
}
