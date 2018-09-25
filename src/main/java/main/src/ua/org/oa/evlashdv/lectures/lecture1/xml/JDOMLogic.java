package ua.org.oa.evlashdv.lectures.lecture1.xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Iterator;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class JDOMLogic {
    public static Document create(List<Student>list){
        Element root=new Element("studentsnew");
        Iterator<Student> studentIterator=list.iterator();
        while (studentIterator.hasNext()){
            Student student=studentIterator.next();
            Element studentElement=new Element("student");
            studentElement.setAttribute("login",student.getLogin());
            studentElement.setAttribute("phone",student.getTelephone());
            Element faculty=new Element("faculty");
            faculty.setText(student.getFaculty());
            studentElement.addContent(faculty);
            Element name=new Element("name");
            name.setText(student.getName());
            studentElement.addContent(name);
            Element addressElement=new Element("address");
            Address address=student.getAddress();
            Element country=new Element("country");
            country.setText(address.getCity());
            addressElement.addContent(country);
            Element city=new Element("city");
            city.setText(address.getCity());
            addressElement.addContent(city);
            Element street=new Element("street");
            street.setText(address.getStreet());
            addressElement.addContent(street);
            studentElement.addContent(addressElement);
            root.addContent(studentElement);
        }
        return new Document(root);
    }
    public static boolean saveDocument(String fileName,Document doc){
        boolean complete=true;
        XMLOutputter outputter=new XMLOutputter();
        try {
            outputter.output(doc,new FileOutputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            complete = false;
        } catch (IOException e) {
            e.printStackTrace();
            complete = false;
        }
        return complete;
    }
}
