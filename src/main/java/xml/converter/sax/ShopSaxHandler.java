package xml.converter.sax;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import xml.entity.Goods;
import xml.entity.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopSaxHandler extends SAXHandler<Shop> {
    Goods goods;
    List<Goods> list;
    String currentTag = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case ("shop"):
                entity = new Shop();
                list = new ArrayList<>();
                break;
            case ("goods"):
                goods = new Goods();
                goods.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case ("name"):
            case ("price"):
            case ("category"):
            case ("description"):
                currentTag = qName;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch (currentTag) {
            case ("name"):
                goods.setName(String.copyValueOf(ch, start, length));
                break;
            case ("price"):
                goods.setPrice(Float.parseFloat(String.copyValueOf(ch, start, length)));
                break;
            case ("category"):
                goods.setCategory(String.copyValueOf(ch, start, length));
                break;
            case ("description"):
                goods.setDescription(String.copyValueOf(ch, start, length));
                break;
        }
        currentTag = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case ("shop"):
                entity.setGoodsList(list);
                break;
            case ("goods"):
                list.add(goods);
                break;
        }
    }
}
