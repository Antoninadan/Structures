package ua.i.mail100.collection;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Good {
    private static final String DATE_FORMAT = "yyyy.MM.dd";

    private String name;
    private String producer;
    private Date manufactureDate;
    private int price;
    private int amount;
    private CategoryNode categoryNode;

    public Good(String name, String producer, Date manufactureDate, Integer price, Integer amount, CategoryNode categoryNode) {
        this.name = name;
        this.producer = producer;
        this.manufactureDate = manufactureDate;
        this.price = price;
        this.amount = amount;
        this.categoryNode = categoryNode;
    }

    public int getPrice() {
        return price;
    }

    public CategoryNode getCategoryNode() {
        return categoryNode;
    }

    public int getAmount() {
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
        return categoryNode +
                ": " +
                toString() +
                ", price = " + price +
                ", amount = " + amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Good)) return false;
        Good good = (Good) o;
        return getPrice() == good.getPrice() &&
                Objects.equals(name, good.name) &&
                Objects.equals(producer, good.producer) &&
                Objects.equals(manufactureDate, good.manufactureDate) &&
                Objects.equals(getCategoryNode(), good.getCategoryNode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, producer, manufactureDate, getPrice(), getCategoryNode());
    }


    public void decreaseAmount(int amount) {
        this.amount -= amount;
    }

    public void increaseAmount(int amount) {
        this.amount += amount;
    }
}
