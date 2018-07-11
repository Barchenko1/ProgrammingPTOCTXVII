package ua.org.oa.evlashdv.lectures.lecture1.solid;

public class DependencyInversion {
    public static void main(String[] args) {

    }
}
interface DAO{
    void execute();
}
class DataAccess implements DAO{
    public void execute(){
        System.out.println("execute");
    }
}
class Client{
    DAO dataAccess=new DataAccess();
    void doJob(){
        dataAccess.execute();
    }
}