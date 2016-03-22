package xml;


import xml.converter.XmlConverter;
import xml.converter.domHandler.ShopDomHandler;
import xml.converter.saxHandler.ShopSaxHandler;
import xml.entity.Shop;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        XmlConverter xmlConverter = new XmlConverter();
        ResourcesUtil resourcesUtil = new ResourcesUtil();
        try {
            //SAX
            Shop saxShop;
            InputStream inputStreamOfResource = resourcesUtil.getInputStreamOfResource("shopSource.xml");
            saxShop = xmlConverter.parse(inputStreamOfResource, new ShopSaxHandler());
            System.out.println(saxShop);

            //DOM
            Shop domShop;
            domShop = xmlConverter.parse(inputStreamOfResource, new ShopDomHandler());
            System.out.println(domShop);

            //JAXB
            //unmarshal
            Shop jaxbShop;
            jaxbShop = xmlConverter.unmarshal(Shop.class, inputStreamOfResource);
            System.out.println(jaxbShop);
            //marshal
            String marshalXmlLocation = resourcesUtil.loadPropertiesFromResources(new Properties(), "config.properties")
                    .getProperty("marshal.location") + File.separator + "shopMarshal.xml";
            xmlConverter.marshal(jaxbShop, new File(marshalXmlLocation));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
