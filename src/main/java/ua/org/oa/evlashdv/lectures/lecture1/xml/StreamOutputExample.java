package ua.org.oa.evlashdv.lectures.lecture1.xml;

import java.io.FileInputStream;
import java.io.InputStream;

public class StreamOutputExample {
    public static void main(String[] args) throws Exception {
        ProductParser parser=new StAXProductParser();
        InputStream input=new FileInputStream("products.xml");
        parser.parse(input);
    }
}
