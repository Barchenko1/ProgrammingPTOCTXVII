package ua.org.oa.evlashdv.lectures.lecture1.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class MainXPath {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
        Document document=db.parse(new File("students.xml"));


        XPathFactory xPathFactory=XPathFactory.newInstance();
        XPath xPath=xPathFactory.newXPath();
        System.out.println(xPath.evaluate("/students/student/address/country",document));
        NodeList list= (NodeList) xPath.evaluate("/students/student/address/country",document, XPathConstants.NODESET);
    }
}
