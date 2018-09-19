package ua.org.oa.evlashdv.lectures.lecture1.xml;

import javax.xml.transform.Transformer; import javax.xml.transform.TransformerException; import javax.xml.transform.TransformerFactory; import javax.xml.transform.stream.StreamResult; import javax.xml.transform.stream.StreamSource;

public class SimpleTransform {
    public static void main(String[] args) {
        try {
            TransformerFactory tf=TransformerFactory.newInstance();
            Transformer transformer=tf.newTransformer(new StreamSource("students2.xsl"));
            transformer.transform(new StreamSource("students.xml"),new StreamResult("newstudents.xml"));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
