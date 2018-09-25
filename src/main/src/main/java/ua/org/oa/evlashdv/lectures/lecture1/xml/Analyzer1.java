package ua.org.oa.evlashdv.lectures.lecture1.xml;

import java.util.ArrayList;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class Analyzer1 {
    public static ArrayList<Student>listBuilder(Element root)throws SAXException,IOException{
        ArrayList<Student> students=new ArrayList<>();
        NodeList studentsNodes=root.getElementsByTagName("student");
        Student student=null;
        for (int i = 0; i <studentsNodes.getLength() ; i++) {
            student=new Student();
            Element studentElement= (Element) studentsNodes.item(i);
            student.setFaculty(studentElement.getAttribute("faculty"));
            student.setName(getBabyValue(studentElement,"name"));
            student.setLogin(studentElement.getAttribute("login"));
            student.setTelephone(getBabyValue(studentElement,"telephone"));
            Address address=student.getAddress();
            Element addressElement=getBaby(studentElement,"address");
            address.setCountry(getBabyValue(addressElement,"country"));
            address.setCity(getBabyValue(addressElement,"city"));
            address.setStreet(getBabyValue(addressElement,"street"));
            students.add(student);
        }
        return students;
    }
    private static Element getBaby(Element parent,String childName){
        NodeList nlist=parent.getElementsByTagName(childName);
        Element child= (Element) nlist.item(0);
        return child;
    }
    private static String getBabyValue(Element parent,String childName){
        Element child=getBaby(parent,childName);
        Node node=child.getFirstChild();
        String value=node.getNodeValue();
        return value;
    }
}
