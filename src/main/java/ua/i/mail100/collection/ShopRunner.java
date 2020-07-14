package ua.i.mail100.collection;

import ua.i.mail100.collection.warehouse.CartWarehouse;
import ua.i.mail100.collection.model.User;

public class ShopRunner {
    public static void main(String[] args) {
        User userOne = new User("Vasya");
        User userTwo = new User("Masha");

        CartWarehouse cartWarehouse = CartWarehouse.getInstance();
        cartWarehouse.getByUser(userOne);

    }
}
