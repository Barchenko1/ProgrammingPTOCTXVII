package ua.org.oa.evlashdv.lectures.lecture1.solid;

public class SingleResponsibility {
    public static void main(String[] args) {
        EmployeeFacade employeeFacade=new EmployeeFacade();
        employeeFacade.cook();
        employeeFacade.cleanFloor();
    }
}
interface Employee{
    int getSalary();
}
class Cooker implements Employee {
    void cook(){}

    @Override
    public int getSalary() {
        return 0;
    }
}
class Janitor implements Employee{

    @Override
    public int getSalary() {
        return 0;
    }
    void cleanFloor(){}
}
class EmployeeFacade{
    Cooker cooker=new Cooker();
    Janitor janitor=new Janitor();
    void cook(){
        cooker.cook();
    }
    void cleanFloor(){
        janitor.cleanFloor();
    }
}

