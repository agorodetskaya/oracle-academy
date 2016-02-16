package xml.converter.saxHandler;

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class SAXHandler<E> extends DefaultHandler {
    E entity;

    public E getEntity() {
        return entity;
    }

    public void setPropertyToFactory(SAXParserFactory factory) {
    }

    public void setPropertyToParser(SAXParser parser) {
    }
}
