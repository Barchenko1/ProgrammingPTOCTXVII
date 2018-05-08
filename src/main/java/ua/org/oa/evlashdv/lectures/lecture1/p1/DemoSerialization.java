package ua.org.oa.evlashdv.lectures.lecture1.p1;

import java.io.*;

class Student1 implements Serializable{
    protected static String faculty;
    private String name;
    private int id;
    private transient String password;
    private static final long serialVersionUID = 1L;

    public Student1(String nameOfFaculty, String name, int id, String password) {
        faculty = nameOfFaculty;
        this.name = name;
        this.id = id;
        this.password = password;
    }
    public String toString(){
        return "\nfaculty " + faculty + "\nname " + name
                + "\nID " + id + "\npassword " + password;
    }
}
public class DemoSerialization {
    public static void main(String[] args) {
        Student1 goncharenko=new Student1("MMF", "Goncharenko", 1, "G017s9");
        System.out.println(goncharenko);
        File fw=new File("demo");
        try {
            ObjectOutputStream ostream= new ObjectOutputStream(new FileOutputStream(fw));
            ostream.writeObject(goncharenko);
            ostream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File fr=new File("demo");
        try {
            ObjectInputStream istream=new ObjectInputStream(new FileInputStream(fr));
            Student unknown =(Student)istream.readObject();
            istream.close();
            System.out.println(unknown);

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
