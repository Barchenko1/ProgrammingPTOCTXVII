package ua.org.oa.evlashdv.lectures.lecture1.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DemoJSR {
    public static void main(String[] args) {
        try {
            JAXBContext context =
                    JAXBContext.newInstance(Student.class);
            Marshaller m = context.createMarshaller();
            Student s = new Student(1, "Bender");//объект
            m.marshal(s, new FileOutputStream("students.xml"));
        } catch (FileNotFoundException e) {
            System.out.println("XMl-файл не найден");
            e.printStackTrace();
        } catch (JAXBException e) {
            System.out.println("JAXB-исключения");
            e.printStackTrace();
        }
    }
    @XmlRootElement
    private static class Student {//внутренний класс
        private int id;
        private String name;
        public Student() {
        }
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public int getID() {
            return id;
        }
        public String getName() {
            return name;
        }
        public void setID(int id) {
            this.id = id;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}

