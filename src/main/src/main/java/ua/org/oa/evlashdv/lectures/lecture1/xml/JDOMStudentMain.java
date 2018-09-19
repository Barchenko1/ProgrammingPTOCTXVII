package ua.org.oa.evlashdv.lectures.lecture1.xml;
import java.util.List;
import org.jdom.*;
import org.jdom.input.SAXBuilder;

import javax.swing.text.Document;
import java.io.IOException;
public class JDOMStudentMain {
    public static void main(String[] args) {
            try {
//создание JDOM
                SAXBuilder builder = new SAXBuilder();
//распознавание XML-документа
                org.jdom.Document document = builder.build("students.xml");
                List<Student> list =
                        JDOMAnalyzer.listCreator(document);
                for (Student st : list) System.out.println(st);
            } catch(IOException e) {
                e.printStackTrace();
            } catch(JDOMException e) {
                e.printStackTrace();
            }
        }
    }

