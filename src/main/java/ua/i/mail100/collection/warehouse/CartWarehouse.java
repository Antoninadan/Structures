package ua.i.mail100.collection.warehouse;

import ua.i.mail100.collection.model.Cart;
import ua.i.mail100.collection.model.User;

import java.util.HashMap;
import java.util.Map;

public class CartWarehouse {
    private Map<User, Cart> savedCarts;
    private static CartWarehouse instance;

    private CartWarehouse() {
        savedCarts = new HashMap<>();
    }

    public static CartWarehouse getInstance() {
        if (instance == null) {
            return new CartWarehouse();
        }
        return instance;
    }

    public Cart getByUser(User user) {
        if (savedCarts.containsKey(user))
            return savedCarts.get(user);
        return savedCarts.put(user, new Cart(user));
   }
}
