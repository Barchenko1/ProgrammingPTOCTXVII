package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;

class Employee {
    private int id;

    public Employee(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void typeEmployee() {
        System.out.println("Работник");
    }
}
class Manager extends Employee  {
    private int idProject;

    public Manager(int id,int idProject){
        super(id);
        this.idProject=idProject;
    }

    public int getIdProject() {
        return idProject;
    }

    public void typeEmployee() {
        System.out.println("Менеджер");
    }
}


public class Test123 {
    public static void main(String[] args) {
        Employee b1 = new Employee(7110);
        Employee b2 = new Manager(9251, 31);
        b1.typeEmployee();
        b2.typeEmployee();
        ((Manager) b2).getIdProject();
        Manager b3 = new Manager(9711, 35);
        System.out.println(b3.getIdProject());
        System.out.println(b3.getId());
    }
}
