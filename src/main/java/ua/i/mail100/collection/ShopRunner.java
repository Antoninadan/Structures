package ua.i.mail100.collection;

import java.util.*;

public class ShopRunner {
    public static void main(String[] args) {
        User userOne = new User("Vasya");
        User userTwo = new User("Masha");

        Date dateOne = new GregorianCalendar(2020, Calendar.JANUARY, 31).getTime();
        Date dateTwo = new GregorianCalendar(2019, Calendar.MAY, 1).getTime();
        Date dateThree = new GregorianCalendar(2018, Calendar.DECEMBER, 19).getTime();
        Date dateFour = new GregorianCalendar(2019, Calendar.OCTOBER, 14).getTime();
        Date dateFive = new GregorianCalendar(2020, Calendar.MAY, 10).getTime();

        CategoryNode categoryNodeOne = new CategoryNode(Category.PHONES_AND_OTHER, null);
        CategoryNode categoryNodeTwo = new CategoryNode(Category.PHONES, categoryNodeOne);
        CategoryNode categoryNodeThree = new CategoryNode(Category.CHARGE, categoryNodeTwo);
        CategoryNode categoryNodeFour = new CategoryNode(Category.RADIO, null);
        CategoryNode categoryNodeFive = new CategoryNode(Category.TV, null);
        CategoryNode categoryNodeSix = new CategoryNode(Category.REMOTE_CONTROLS, categoryNodeFive);
        CategoryNode categoryNodeSeven = new CategoryNode(Category.BATTERY, null);

        Good radio = new Good("radio", "Mayak", dateOne, 1000, 4, categoryNodeFour);
        Good tv = new Good("TV", "Gorizont", dateTwo, 2000, 100, categoryNodeFive);
        Good remote = new Good("remote control", "LG", dateThree, 300, 20, categoryNodeSix);
        Good battery = new Good("battery", "Duracel", dateFour, 50, 150, categoryNodeSeven);
        Good a7 = new Good("A7", "Samsung", dateFive, 20000, 200, categoryNodeTwo);
        Good charge = new Good("Charge Type S", "Samsung", dateFive, 200, 35, categoryNodeThree);
        Good charge2 = new Good("Charge", "LG", dateFive, 170, 40, categoryNodeThree);

        List<Good> shop = new ArrayList<>();
        shop.add(radio);
        shop.add(tv);
        shop.add(remote);
        shop.add(battery);
        shop.add(a7);
        shop.add(charge);
        shop.add(charge2);

        System.out.println("Shop:");
        printShop(shop);
        System.out.println();

        Cart one = new Cart(userOne);
        one.addToCart(a7, 1);
        one.addToCart(remote, 2);
        one.addToCart(charge, 3);
        one.addToCart(charge2, 4);
        one.print();
        System.out.println("total = " + one.getTotal());
        System.out.println();

        System.out.println("Remove a7:");
        one.removeFromCart(a7);
        one.print();
        System.out.println("total = " + one.getTotal());
        System.out.println();
    }

    public static void printShop(List<Good> goods){
        goods.forEach(good -> System.out.println("  - " + good.toStringShop()));
    }
}
