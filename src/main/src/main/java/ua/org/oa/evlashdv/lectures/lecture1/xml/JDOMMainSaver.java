package ua.org.oa.evlashdv.lectures.lecture1.xml;
import org.jdom.Document;

import java.io.IOException;
import java.util.ArrayList;

public class JDOMMainSaver {
    public static void main(String[] args) {
        ArrayList<Student> students=new ArrayList<>();
        for (int j = 1; j < 3; j++) {
            Student st=new Student();
            st.setName("Petrov"+j);
            st.setLogin("petr"+j);
            st.setFaculty("mmf");
            st.setTelephone("454556"+j*3);
            Address adr=st.getAddress();
            adr.setCity("Minsk");
            adr.setCountry("BLR");
            adr.setStreet("Gaja, "+j);
            st.setAddress(adr);
            students.add(st);
        }
        Document doc=JDOMLogic.create(students);
        if (JDOMLogic.saveDocument("studentsnew.xml",doc)){
            System.out.println("Документ создан");
        }else {
            System.out.println("Документ не создан");
        }
    }
}
