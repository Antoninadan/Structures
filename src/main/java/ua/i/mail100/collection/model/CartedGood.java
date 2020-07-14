package ua.i.mail100.collection.model;

import ua.i.mail100.collection.warehouse.CartWarehouse;

import java.util.List;

public abstract class CartedGood implements Purchased {
    private Purchased purchased;
    private int amount;
    private Cart cart;

    public CartedGood(User user, int amount) {
        CartWarehouse cartWarehouse = CartWarehouse.getInstance();
        this.cart = cartWarehouse.getByUser(user);
        this.amount = amount;
    }


    public Cart addToCart(Cart cart, int amount) {
        return null;
    }



    public Cart removeFromCart(Cart cart) {
        return null;
    }



}
