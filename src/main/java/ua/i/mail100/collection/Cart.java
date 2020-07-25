package ua.i.mail100.collection;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<Good, Integer> getGoods() {
        return goods;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart for user ")
                .append(user.getName())
                .append(": ")
                .append(LINE_SEP);

        goods.forEach((k, v) -> stringBuilder.append("  - ")
                .append(k.toString() + " - " + v + " unit.")
                .append(LINE_SEP));

        return stringBuilder.toString();
    }


    public void addToCart(Good good, int amount) {
        if (good.getAmount() < amount) {
            throw new RuntimeException(EXCEPTION_NOT_ENOUGH_GOOD_AMOUNT);
        }

        int newCartAmount = amount;
        if (goods.containsKey(good)) {
            int currentAmount = goods.get(good);
            newCartAmount += currentAmount;
        }
        goods.put(good, newCartAmount);

        good.decreaseAmount(amount);
    }

    public void removeFromCart(Good good) {
        if (!goods.containsKey(good)) {
            throw new RuntimeException(EXCEPTION_ABSENT_GOOD_IN_CART);
        }

        good.increaseAmount(goods.get(good));

        goods.remove(good);

        relatedGoodsRemove(good);
    }

    public void relatedGoodsRemove(Good good) {
        List<Good> relatedGoods = getRelatedGoodsTo(good);

        relatedGoods.forEach(i -> {
            i.increaseAmount(goods.get(i));
            goods.remove(i);
        });
    }

    public List<Good> getRelatedGoodsTo(Good good) {
        CategoryNode node = good.getCategoryNode();

        return goods.entrySet()
                .stream()
                .filter(e -> node.isChild(e.getKey().getCategoryNode()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    public void relatedGoodsRemove2(Good good) {
        CategoryNode node = good.getCategoryNode();

        goods.entrySet()
                .parallelStream()
                .filter(e -> CategoryNode.isChild(e.getKey().getCategoryNode(), node))
                .map(e -> {
                    Good key = e.getKey();
                    key.setAmount(key.getAmount() + goods.get(key));
                    return key;
                }).forEach(k -> goods.remove(k));
    }

    public int getTotal2() {
        Purchased purchased = (m) -> {
            int total = 0;

            for (Map.Entry<Good, Integer> each : m.entrySet())
                total += each.getValue() * each.getKey().getPrice();

            return total;
        };

        return purchased.getTotalPrice(goods);
    }

    public int getTotal() {
        Purchased purchased = m -> m
                .entrySet()
                .stream()
                .mapToInt(e -> e.getValue() * e.getKey().getPrice())
                .sum();

        return purchased.getTotalPrice(goods);
    }
}

/*
 * String str = "Hello";
 *
 * iter0 -> str + 0 -> str = "Hello0"; "Hello"
 * iter1 ->  + 0 -> str = "Hello0"; "Hello"
 * */

