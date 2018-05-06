package ua.org.oa.evlashdv.lectures.lecture1.p1;

import java.util.Arrays;

class Student{
    private int id;
    private  EmamResult[] exams;

    public Student(int id) {
        this.id = id;
    }
    private class EmamResult{
        private String name;
        private int mark;
        private boolean passed;
        public EmamResult(String name){
            this.name=name;
            passed=false;
        }
        public void passExam(){
            passed=true;
        }
        public void setMark(int mark){
            this.mark=mark;
        }

        public int getMark() {
            return mark;
        }
        public int getPassedMark(){
            final int PASSED_MARK=4;
            return PASSED_MARK;
        }

        public String getName() {
            return name;
        }
        public boolean isPassed(){
            return passed;
        }
    }
    public void setExams(String []name,int[] marks) throws IllegalAccessException {
        if (name.length!=marks.length){
            throw new IllegalAccessException();
        }
        exams=new EmamResult[name.length];
        for (int i = 0; i < name.length; i++) {
            exams[i]=new EmamResult(name[i]);
            exams[i].setMark(marks[i]);
            if (exams[i].getMark()>=exams[i].getPassedMark()){
                exams[i].passExam();
            }
        }
    }

    public String toString() {
        String res = "Студент: " + id + "\n";
        for (int i = 0; i < exams.length; i++)
            if (exams[i].isPassed())
                res += exams[i].getName() + " сдал \n";
            else
                res += exams[i].getName() + " не сдал \n";
        return res;
    }
}
public class AnySession {
    public static void main(String[] args) throws IllegalAccessException {
        Student stud=new Student(822201);
        String ex[]={"Механника","Программирование"};
        int marks[]={2,9};
        stud.setExams(ex,marks);
        System.out.println(stud);
    }
}
