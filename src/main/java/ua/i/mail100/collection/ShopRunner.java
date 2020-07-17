package ua.i.mail100.collection;

import ua.i.mail100.collection.model.*;

import java.util.Date;

public class ShopRunner {
    public static void main(String[] args) {
        User userOne = new User("Vasya");
        User userTwo = new User("Masha");

//        CartWarehouse cartWarehouse = CartWarehouse.getInstance();
//        Cart cartOne = cartWarehouse.getByUser(userOne);
//        cartOne.print();

        Good radio = new Good("radio", "Mayak", new Date(), 12);
        Good tv = new Good("TV", "Gorizont", new Date(), 100);
        Good remote = new Good("remote control", "LG", new Date(), 20);
        Good battery = new Good("battery", "Duracel", new Date(), 1000);
        Good a7 = new Good("A7", "Sumsung", new Date(), 200);

        RelatedGood remoteTV = new RelatedGood(remote, tv);
        RelatedGood batteryRadio = new RelatedGood(battery, radio);

        Cart cartUserOne = new Cart(userOne);
        Cart cartUserTwo = new Cart(userTwo);

    }
}

/*
* Mobile (Category: PHONE, subcategory: PHONE)
* Headphone (Category: PHONE, subcategory: HEADPHONE)
* Charger (Category: PHONE, subcategory: CHARGER)
*
*
*
*
* */
