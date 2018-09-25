package ua.org.oa.evlashdv.lectures.lecture1.xml;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;

public class SAXStudentMain {
    public static void main(String[] args) {
        try {
            XMLReader reader= XMLReaderFactory.createXMLReader();
            StudentHandler1 sh1=new StudentHandler1();
            reader.setContentHandler(sh1);
            ArrayList<Student> list;
            if (sh1!=null){
                reader.parse("students.xml");
                System.out.println(sh1.getStudents());
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
