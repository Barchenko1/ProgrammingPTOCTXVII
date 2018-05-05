package ua.org.oa.evlashdv.lectures.lecture1.p1;
class Course{
    private int id;
    private String name;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Название: " + name + "(" + id + ")";
    }
}
class BaseCourse extends Course{
    private int idTeacher;

    public BaseCourse(int id, String name, int idTeacher) {
        super(id, name);
        this.idTeacher = idTeacher;
    }

    public BaseCourse() {
    }

    @Override
    public String toString() {
        return super.toString() + " препод.(" + idTeacher + ")";
    }
}
class OptionCourse extends BaseCourse{
    private boolean required;

    public OptionCourse(int id, String name, int idTeacher, boolean required) {
        super(id, name, idTeacher);
        this.required = required;
    }

    @Override
    public String toString() {
        return super.toString() + " required->" + required;
    }
}
class DynDispatcher{
    public void infoCourse(Course c){
        System.out.println(c);
    }
}
public class Runner {
    public static void main(String[] args) {
        DynDispatcher d=new DynDispatcher();
        Course cc=new Course(7,"MA");
        d.infoCourse(cc);
        BaseCourse bc=new BaseCourse(71,"МП",2531);
        d.infoCourse(bc);
        OptionCourse oc=new OptionCourse(35,"ФА",4128,true);
        d.infoCourse(oc);
    }
}
