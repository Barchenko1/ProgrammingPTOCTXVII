package ua.org.oa.evlashdv.lectures.lecture1.xml;

import java.util.*;
import java.io.IOException;
import org.jdom.Element;
import org.jdom.Document;
import org.jdom.JDOMException;


public class JDOMAnalyzer {
    public static List<Student> listCreator(Document doc)throws JDOMException, IOException {
        Element root = doc.getRootElement();
        List studElem = root.getChildren();
        Iterator studentIterator = studElem.iterator();
        ArrayList<Student> students=new ArrayList<>();
        while (studentIterator.hasNext()){
            Element studentElement= (Element) studentIterator.next();
            Student student=new Student();
            student.setLogin(studentElement.getAttributeValue("login"));
            student.setName(studentElement.getChild("name").getText());
            student.setTelephone(studentElement.getChild("telephone").getText());
            student.setFaculty(studentElement.getAttributeValue("faculty"));

            Element addressElement=studentElement.getChild("address");
            Address address=student.getAddress();
            address.setCountry(addressElement.getChild("country").getText());
            address.setCity(addressElement.getChild("city").getText());
            address.setStreet(addressElement.getChild("street").getText());
            students.add(student);
        }
        return students;
    }
}
