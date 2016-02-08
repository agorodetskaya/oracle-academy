package xml.converter.domHandler;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xml.entity.Goods;
import xml.entity.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopDomHandler implements DomHandler<Shop> {
    private Shop shop;
    private Goods goods;
    private List<Goods> list;

    @Override
    public Shop handle(Document document) {
        Element rootElement = document.getDocumentElement();
        handleRoot(rootElement);
        return shop;
    }

    private void handleRoot(Element element) {
        if ("shop".equals(element.getNodeName())) {
            shop = new Shop();
            list = new ArrayList<>();
            if (element.hasChildNodes()) {
                NodeList nodeList = element.getChildNodes();
                for (int i = 0; i < nodeList.getLength(); i++) {
                    handleGoods(nodeList.item(i));
                }
            }
            shop.setGoodsList(list);
        }
    }

    private void handleGoods(Node node) {
        if (!node.hasChildNodes() && StringUtils.isBlank(node.getNodeValue())) {
            return;
        }
        goods = new Goods();
        goods.setId(Integer.parseInt(node.getAttributes().getNamedItem("id").getNodeValue()));
        if (node.hasChildNodes()) {
            NodeList nodeList = node.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                handleGoodsChildNode(nodeList.item(i));
            }
        }
        list.add(goods);
    }

    private void handleGoodsChildNode(Node node) {
        if (!node.hasChildNodes() && StringUtils.isBlank(node.getNodeValue())) {
            return;
        }
        switch (node.getNodeName()) {
            case ("name"):
                goods.setName(node.getFirstChild().getNodeValue());
                break;
            case ("price"):
                goods.setPrice(Float.parseFloat(node.getFirstChild().getNodeValue()));
                break;
            case ("category"):
                goods.setCategory(node.getFirstChild().getNodeValue());
                break;
            case ("description"):
                goods.setDescription(node.getFirstChild().getNodeValue());
                break;
        }
    }
}
