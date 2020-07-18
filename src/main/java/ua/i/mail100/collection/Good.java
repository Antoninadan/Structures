package ua.i.mail100.collection;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Good {
    private static final String DATE_FORMAT = "yyyy.MM.dd";

    private String name;
    private String producer;
    private Date manufactureDate;
    private Integer price;
    private Integer amount;
    private CategoryNode categoryNode;

    public Good(String name, String producer, Date manufactureDate, Integer price, Integer amount, CategoryNode categoryNode) {
        this.name = name;
        this.producer = producer;
        this.manufactureDate = manufactureDate;
        this.price = price;
        this.amount = amount;
        this.categoryNode = categoryNode;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public CategoryNode getCategoryNode() {
        return categoryNode;
    }

    public void setCategoryNode(CategoryNode categoryNode) {
        this.categoryNode = categoryNode;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        return name +
                " " + producer +
                ", " + dateFormat.format(manufactureDate);
    }

    public String toStringShop() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        return categoryNode+
                ": " + name +
                " " + producer +
                ", " + dateFormat.format(manufactureDate) +
                ", price = " + price +
                ", amount = " + amount;
    }

}
