package xml;


import xml.converter.XmlConverter;
import xml.converter.saxHandler.ShopSaxHandler;
import xml.entity.Shop;

import java.io.File;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        XmlConverter xmlConverter = new XmlConverter();
        ResourcesUtil resourcesUtil = new ResourcesUtil();
        try {
            //SAX
            Shop saxShop;
            saxShop =
                    xmlConverter.parse(resourcesUtil.getInputStreamOfResource("shopSource.xml"), new ShopSaxHandler());
            System.out.println(saxShop);

            //DOM
            Shop domShop;
            domShop =
                    xmlConverter.parse(resourcesUtil.getInputStreamOfResource("shopSource.xml"), new ShopSaxHandler());
            System.out.println(domShop);

            //JAXB
            //unmarshal
            Shop jaxbShop;
            jaxbShop = xmlConverter.unmarshal(Shop.class, resourcesUtil.getInputStreamOfResource("shopSource.xml"));
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
