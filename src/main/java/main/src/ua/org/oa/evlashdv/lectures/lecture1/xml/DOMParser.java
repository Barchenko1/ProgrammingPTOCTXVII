package ua.org.oa.evlashdv.lectures.lecture1.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMParser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file=new File("students.xml");
        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder=dbFactory.newDocumentBuilder();
        Document doc=documentBuilder.parse(file);

        Element element=doc.getDocumentElement();
        System.out.println(element.getTagName());
        NodeList nodeList=element.getChildNodes();
        for (int i = 0; i <nodeList.getLength() ; i++) {
            if (nodeList.item(i)instanceof Element){
                System.out.println(((Element) nodeList.item(i)).getTagName());
            }
        }
//            System.out.println("root element: "+doc.getDocumentElement().getNodeName());
//            NodeList nodeList=doc.getElementsByTagName("course");
//            for (int i = 0; i <nodeList.getLength() ; i++) {
//                Node node=nodeList.item(i);
//                System.out.println("Element: "+node.getNodeName());
//                if (node.getNodeType()==node.ELEMENT_NODE){
//                    Element element= (Element) node;
//                    System.out.println(element.getAttribute("id"));
//                    System.out.println(element.getElementsByTagName("name").item(0).getTextContent());
//                    System.out.println(element.getElementsByTagName("teacher").item(0).getTextContent());
//                    System.out.println(element.getElementsByTagName("hours").item(0).getTextContent());
//                    System.out.println(element.getElementsByTagName("day").item(0).getTextContent());
//                }
//            }
    }
}
