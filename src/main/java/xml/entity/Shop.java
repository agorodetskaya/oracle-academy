package xml.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Shop {
    private List<? extends Goods> goodsList;

    public Shop(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public Shop() {
    }

    public List<? extends Goods> getGoodsList() {
        return goodsList;
    }

    @XmlElement(name = "goods")
    public void setGoodsList(List<? extends Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Shop:\n").append("List of Goods{ \n");
        for (Goods goods : goodsList) {
            stringBuilder.append(goods.toString()).append("\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
