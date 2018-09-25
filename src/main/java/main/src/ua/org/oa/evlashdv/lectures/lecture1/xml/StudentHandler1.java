package ua.org.oa.evlashdv.lectures.lecture1.xml;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.ContentHandler;
import java.net.URLConnection;
import java.util.ArrayList;

public class StudentHandler1 implements org.xml.sax.ContentHandler {
    ArrayList<Student> students=new ArrayList<>();
    Student curr=null;
    StudentEnum currentEnum=null;

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("parsing started");
    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("student")){
            curr=new Student();
            curr.setLogin(atts.getValue(0));
            curr.setFaculty(atts.getValue(1));
        }
        if ((!"address".equals(qName))&&(!"student".equals(qName))&&(!qName.equals("students"))){
            currentEnum=StudentEnum.valueOf(qName.toUpperCase());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("student")){
            students.add(curr);
        }currentEnum=null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s=new String (ch,start,length).trim();
        if (currentEnum==null)return;
        switch (currentEnum){
            case NAME:curr.setName(s);break;
            case TELEPHONE:curr.setTelephone(s);break;
            case STREET:curr.getAddress().setStreet(s);break;
            case CITY:curr.getAddress().setCity(s);break;
            case COUNTRY:curr.getAddress().setCountry(s);break;
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }
}
