package ua.i.mail100.collection.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private static final String LINE_SEP = System.getProperty("line.separator");
    private static final String EXCEPTION_NOT_ENOUGH_GOOD_AMOUNT = "Not enough good amount in shop";
    private static final String EXCEPTION_ABSENT_GOOD_IN_CART = "Good is absent in cart";

    private User user;
    private Map<Good, Integer> goods;

    public Cart(User user) {
        this.user = user;
        goods = new LinkedHashMap<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Good, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<Good, Integer> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart for user ");
        stringBuilder.append(user.getName());
        stringBuilder.append(": ");
        stringBuilder.append(LINE_SEP);

        for (Map.Entry<Good, Integer> each : goods.entrySet()) {
            stringBuilder.append("  - ");
            stringBuilder.append(each.getKey().toString() + " - " + each.getValue() + " unit.");
            stringBuilder.append(LINE_SEP);
        }
        return stringBuilder.toString();
    }

    public void print() {
        System.out.println(this);
    }

    public void addToCart(Good good, Integer amount) {
        if (good.getAmount() < amount) {
            throw new RuntimeException(EXCEPTION_NOT_ENOUGH_GOOD_AMOUNT);
        }
        if (goods.containsKey(good)) {
            int currentAmount = goods.get(good);
            goods.put(good, currentAmount + amount);
        } else {
            goods.put(good, amount);
        }
        good.setAmount(good.getAmount() - amount);
    }

    // TODO sub goods delete
    public void removeFromCart(Good good) {
        if (!goods.containsKey(good)) {
            throw new RuntimeException(EXCEPTION_ABSENT_GOOD_IN_CART);
        }
        good.setAmount(good.getAmount() + goods.get(good));
        goods.remove(good);
    }

    public int getTotal() {
        Purchased purchased = (m) -> {
            return 1;
        };
        return 1;
    }
}

