package ua.org.oa.evlashdv.lectures.lecture1.p1;

class CourseHelper {
    public Course getCourse(){
        System.out.println("Course");
        return new Course();
    }
}

class BaseCourseHelper extends CourseHelper {
    @Override
    public BaseCourse getCourse(){
        System.out.println("BaseCourse");
        return new BaseCourse();
    }
}

public class RunnerCourse {
    public static void main(String[] args) {
        CourseHelper bch = new BaseCourseHelper();
        Course course = bch.getCourse();
//BaseCourse course = bch.getCourse();//ошибка компиляции
        System.out.println(bch.getCourse().getId());
    }
}
