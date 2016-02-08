package xml.converter.domHandler;


import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public interface DomHandler<E> {
    E handle(Document document);

    default void setPropertyToFactory(DocumentBuilderFactory factory) {
    }

    default void setPropertyToBuilder(DocumentBuilder documentBuilder) {
    }
}
