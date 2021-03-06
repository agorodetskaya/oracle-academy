package xml.converter;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import xml.converter.domHandler.DomHandler;
import xml.converter.saxHandler.SAXHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class XmlConverter {
    public <E> E parse(InputStream inputFile, SAXHandler<E> saxHandler)
            throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxHandler.setPropertyToFactory(saxParserFactory);
        SAXParser parser = saxParserFactory.newSAXParser();
        saxHandler.setPropertyToParser(parser);
        parser.parse(inputFile, saxHandler);
        return saxHandler.getEntity();
    }

    public <E> E parse(File inputFile, SAXHandler<E> saxHandler)
            throws ParserConfigurationException, SAXException, IOException {
        return parse(new FileInputStream(inputFile), saxHandler);
    }

    public <E> E parse(InputStream inputFile, DomHandler<E> domHandler)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        domHandler.setPropertyToFactory(documentBuilderFactory);
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        domHandler.setPropertyToBuilder(builder);
        Document document = builder.parse(inputFile);
        document.normalize();
        return domHandler.handle(document);
    }

    public <E> E parse(File inputFile, DomHandler<E> domHandler)
            throws ParserConfigurationException, SAXException, IOException {
        return parse(new FileInputStream(inputFile), domHandler);
    }

    public <E> void marshal(E e, OutputStream outputFile)
            throws JAXBException, IllegalAccessException, InstantiationException {
        JAXBContext jaxbContext = JAXBContext.newInstance(e.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(e, outputFile);
    }

    public <E> void marshal(E e, File outputFile)
            throws JAXBException, IllegalAccessException, InstantiationException, FileNotFoundException {
        marshal(e, new FileOutputStream(outputFile));
    }

    public <E> E unmarshal(Class<E> clazz, InputStream inputFile)
            throws JAXBException, IllegalAccessException, InstantiationException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return clazz.cast(unmarshaller.unmarshal(inputFile));
    }

    public <E> void unmarshal(Class<E> clazz, File inputFile)
            throws JAXBException, IllegalAccessException, InstantiationException, FileNotFoundException {
        unmarshal(clazz, new FileInputStream(inputFile));
    }
}
