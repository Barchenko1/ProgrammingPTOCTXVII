package ua.org.oa.evlashdv.lectures.lecture1.xml;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainSax {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
//        XMLReader reader= XMLReaderFactory.createXMLReader();
//        SimpleHandler contentHandler=new SimpleHandler();
//        reader.setContentHandler(contentHandler);
//        reader.parse("students.xml");

        DefaultHandler handler=new DefaultHandler(){
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                String name=attributes.getValue("");
                if (name!=null&&!name.isEmpty()){
                    System.out.print(name);
                }
            }

            @Override
            public void characters(char[] ch, int start, int length)  {
                String str="";
                for (int i = 0; i < length; i++) {
                    str+=ch[start+i];
                }
                System.out.print(str);
            }
        };

        SAXParserFactory factory=SAXParserFactory.newInstance();
        SAXParser parser=factory.newSAXParser();
        parser.parse(new File("students.xml"),handler);

        //StAX
//        XMLInputFactory factory2=XMLInputFactory.newInstance();
//        XMLStreamReader parser2=factory2.createXMLStreamReader(new FileInputStream("students.xml"));
//        while (parser2.hasName()){
//            int event=parser2.next();
//            if (event== XMLStreamConstants.START_DOCUMENT){
//                System.out.println(parser2.getLocalName());
//            }
//            if (event==XMLStreamConstants.CHARACTERS){
//                System.out.println(parser2.getLocalName());
//            }
//        }
    }
}
