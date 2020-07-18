package ua.i.mail100.collection;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

    public void removeFromCart(Good good) {
        if (!goods.containsKey(good)) {
            throw new RuntimeException(EXCEPTION_ABSENT_GOOD_IN_CART);
        }

        good.setAmount(good.getAmount() + goods.get(good));
        goods.remove(good);
        relatedGoodsRemove(good);

    }

    public void relatedGoodsRemove(Good good) {
        List<Good> relatedGoods = getRelatedGoodsTo(good);
        for (Good each : relatedGoods) {
            each.setAmount(each.getAmount() + goods.get(each));
            goods.remove(each);
        }
    }

    public List<Good> getRelatedGoodsTo(Good good) {
        List<Good> result = new ArrayList<>();
        CategoryNode node = good.getCategoryNode();

        for (Map.Entry<Good, Integer> each : goods.entrySet()) {
            CategoryNode eachNode = each.getKey().getCategoryNode();
            if (CategoryNode.isChild(eachNode, node))
                result.add(each.getKey());
        }
        return result;
    }

    public int getTotal() {
        Purchased purchased = (m) -> {
            int total = 0;
            for(Map.Entry<Good, Integer> each:m.entrySet())
            total += each.getValue() * each.getKey().getPrice();
            return total;
        };
        return purchased.getTotalPrice(goods);
    }
}

