package ua.i.mail100.collection.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cart{
    private User user;
    private List<CartedGood> cartedGoods;
    // ниже
//    private Map<Good, Integer> cartedGoods;

    public Cart(User user) {
        this.user = user;
        cartedGoods = new ArrayList<>();
    }

    public void print(){
        System.out.println("Cart for user \"" + user.getName() + "\":");
        for (CartedGood each:cartedGoods) {
            System.out.println(each.toString());
        }
    }

    public void addToCart(CartedGood cartedGood) {
        if (cartedGoods.contains(cartedGood)){
            cartedGood.changeAmount(cartedGood.getAmount());
        }
        cartedGoods.add(cartedGood);
    }

    public void removeFromCart(CartedGood cartedGood) {
        cartedGoods.remove(cartedGood);
    }

    public int getTotal(){
        Purchased purchased = (m) -> {
            return  1;
        };
        return 1;
    }
}


// TODO uniq