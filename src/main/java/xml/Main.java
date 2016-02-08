package xml;


import xml.entity.Shop;
import xml.converter.XmlConverter;
import xml.converter.saxHandler.ShopSaxHandler;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        XmlConverter xmlConverter = new XmlConverter();
        ResourcesUtil resourcesUtil = new ResourcesUtil();
        try {
            //SAX
            Shop saxShop;
            saxShop = xmlConverter.parse(resourcesUtil.getValidNameOfResource("shopSource.xml"), new ShopSaxHandler());
            System.out.println(saxShop);

            //DOM
            Shop domShop;
            domShop = xmlConverter.parse(resourcesUtil.getValidNameOfResource("shopSource.xml"), new ShopSaxHandler());
            System.out.println(domShop);

            //JAXB
            //unmarshal
            Shop jaxbShop;
            jaxbShop = xmlConverter.unmarshal(Shop.class, resourcesUtil.getValidNameOfResource("shopSource.xml"));
            System.out.println(jaxbShop);
            //marshal
            xmlConverter.marshal(jaxbShop, new File("src/main/resources/shopMurshal.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
