package ua.org.oa.evlashdv.lectures.lecture1.servlet;

public class MyModel {
    public Student getStudent(){
        Student student=new Student();
        student.setName("Max");
        student.setAge(22);
        return student;
    }
}
