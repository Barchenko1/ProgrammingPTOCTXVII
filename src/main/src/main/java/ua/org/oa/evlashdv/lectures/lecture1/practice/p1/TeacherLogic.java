package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;
abstract class AbstactTeacher{
    private int id;

    public AbstactTeacher(int id) {
        this.id = id;
    }
    abstract boolean excludeStudent(String name);
}
class Teacher extends AbstactTeacher{
    public Teacher(int id) {
        super(id);
    }

    @Override
    boolean excludeStudent(String name) {
        return false;
    }
}
class TeacherCreator{
    public TeacherCreator() {
    }
    public AbstactTeacher createTeacher(int id){
        class Dean extends AbstactTeacher{
            public Dean(int id) {
                super(id);
            }

            @Override
            boolean excludeStudent(String name) {
                if (name!=null){return true;
                } else return false;
            }
        }
        if (isDeanId(id)){
            return new Dean(id);
        }else return new Teacher(id);
    }
    private static boolean isDeanId(int id){
        return id==777;
    }
}
public class TeacherLogic {
public static void excludeProcess(int deanId,String name){
    AbstactTeacher teacher=new TeacherCreator().createTeacher(deanId);
    System.out.println("Студент: " + name
            + " отчислен:" + teacher.excludeStudent(name));
}
    public static void main(String[] args) {
        excludeProcess(700,"Балаганов");
        excludeProcess(777,"Балаганов");
    }
}
