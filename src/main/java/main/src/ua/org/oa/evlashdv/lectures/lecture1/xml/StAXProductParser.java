package ua.org.oa.evlashdv.lectures.lecture1.xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class StAXProductParser extends ProductParser{
    @Override
    public void parse(InputStream input) {
        XMLInputFactory inputFactory=XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader=inputFactory.createXMLStreamReader(input);
            process(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
    void process(XMLStreamReader reader) throws XMLStreamException {
        String name;
        while (reader.hasName()){
            int type=reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (ParserEnum.valueOf(name.toUpperCase())){
                        case PRODUCTS:
                            writeTitle();
                            break;
                        case CATEGORY:
                            writeCategoryStart(reader.getAttributeValue(null,
                                    ParserEnum.NAME.name().toLowerCase()));
                            break;
                        case SUBCATEGORY:
                            writeSubcategoryStart(reader.getAttributeValue(null,
                                    ParserEnum.NAME.name().toLowerCase()));
                            break;
                        case PRODUCT:
                            writeProductStart();
                            break;
                        default:
                            writeProductFeatureStart(name);
                            break;
                    }break;
                case XMLStreamConstants.END_ELEMENT:
                    name=reader.getLocalName();
                    switch (ParserEnum.valueOf(name.toUpperCase())) {
                        case CATEGORY:
                            writeCategoryEnd();
                            break;
                        case SUBCATEGORY:
                            writeSubcategoryEnd();
                            break;
                        case PRODUCT:
                            writeProductEnd();
                            break;
                        default:
                            writeProductFeatureEnd();
                            break;
                    }
                    break;
                    case XMLStreamConstants.CHARACTERS:
                        writeText(reader.getText());break;
                        default:break;
                    }
            }
        }
    }

