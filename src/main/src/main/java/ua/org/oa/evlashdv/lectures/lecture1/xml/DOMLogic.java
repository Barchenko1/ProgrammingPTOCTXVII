package ua.org.oa.evlashdv.lectures.lecture1.xml;
import java.util.ArrayList;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;



public class DOMLogic {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            Document document=db.parse("students.xml");

            Element root=document.getDocumentElement();
            ArrayList<Student> students = Analyzer1.listBuilder(root);
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i));
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
