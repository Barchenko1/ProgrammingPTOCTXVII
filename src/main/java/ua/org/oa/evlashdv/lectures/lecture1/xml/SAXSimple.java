package ua.org.oa.evlashdv.lectures.lecture1.xml;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SAXSimple {
    public static void main(String[] args) {
        try {
            XMLReader reader= XMLReaderFactory.createXMLReader();
            SimpleHandler contentHandler=new SimpleHandler();
            reader.setContentHandler(contentHandler);
            reader.parse("students.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
