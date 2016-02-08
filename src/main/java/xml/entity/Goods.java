package xml.entity;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.StringJoiner;


public class Goods {
    private long id;
    private String name;
    private double price;
    private String category;
    private String description;

    public Goods(long id, String name, double price, String category, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public Goods() {
    }

    public long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("; ", "Goods: ", ".");
        stringJoiner.add("Goods: id = " + getId())
                .add("name = " + getName())
                .add("price = " + getPrice())
                .add("category = " + getCategory())
                .add("description = " + getDescription());
        return stringJoiner.toString();
    }
}
