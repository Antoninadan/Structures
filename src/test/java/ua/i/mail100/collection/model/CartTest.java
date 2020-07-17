package ua.i.mail100.collection.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private static final String LINE_SEP = System.getProperty("line.separator");

    User userOne;
    User userTwo;

    Good radio;
    Good tv;
    Good remote;
    Good battery;
    Good a7;
    Good charge;

    @BeforeEach
    void setUp() {
        userOne = new User("Vasya");
        userTwo = new User("Masha");

        Date dateOne = new GregorianCalendar(2020, Calendar.JANUARY, 31).getTime();
        Date dateTwo = new GregorianCalendar(2019, Calendar.MAY, 1).getTime();
        Date dateThree = new GregorianCalendar(2018, Calendar.DECEMBER, 19).getTime();
        Date dateFour = new GregorianCalendar(2019, Calendar.OCTOBER, 14).getTime();
        Date dateFive = new GregorianCalendar(2020, Calendar.MAY, 10).getTime();

        CategoryNode categoryNodeOne = new CategoryNode(Category.PHONES, null);
        CategoryNode categoryNodeTwo = new CategoryNode(Category.PHONES, categoryNodeOne);
        CategoryNode categoryNodeThree = new CategoryNode(Category.CHARGE, categoryNodeTwo);
        CategoryNode categoryNodeFour = new CategoryNode(Category.RADIO, null);
        CategoryNode categoryNodeFive = new CategoryNode(Category.TV, null);
        CategoryNode categoryNodeSix = new CategoryNode(Category.REMOTE_CONTROLS, categoryNodeFive);
        CategoryNode categoryNodeSeven = new CategoryNode(Category.BATTERY, null);


        radio = new Good("radio", "Mayak", dateOne, 4, categoryNodeFour);
        tv = new Good("TV", "Gorizont", dateTwo, 100, categoryNodeFive);
        remote = new Good("remote control", "LG", dateThree, 20, categoryNodeSix);
        battery = new Good("battery", "Duracel", dateFour, 1000, categoryNodeSeven);
        a7 = new Good("A7", "Samsung", dateFive, 200, categoryNodeTwo);
        charge = new Good("Charge Type S", "Samsung", dateFive, 35, categoryNodeThree);
    }

    @Test
    void toStringTest() {
        Cart one = new Cart(userOne);
        one.addToCart(radio, 1);
        one.addToCart(remote, 2);

        String expected = "Cart for user Vasya: " + LINE_SEP +
                "  - radio Mayak, 2020.01.31 - 1 unit." + LINE_SEP +
                "  - remote control LG, 2018.12.19 - 2 unit." + LINE_SEP;
        assertEquals(expected, one.toString());
    }

    @Test
    void addToCart() {
        Cart one = new Cart(userOne);
        one.addToCart(radio, 1);
        one.addToCart(radio, 2);
        one.addToCart(remote, 2);

        assertEquals(3, one.getGoods().get(radio));
        assertEquals(2, one.getGoods().get(remote));
        assertEquals(1, radio.getAmount());
        assertEquals(18, remote.getAmount());
    }

    @Test
    void addToCartNotEnoughAmount() {
        Cart one = new Cart(userOne);

        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            one.addToCart(radio, 10);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void removeFromCart() {
        Cart one = new Cart(userOne);
        one.addToCart(radio, 1);

        assertEquals(1, one.getGoods().get(radio));
        assertEquals(3, radio.getAmount());

        one.removeFromCart(radio);
        assertFalse(one.getGoods().containsKey(radio));
        assertEquals(4, radio.getAmount());
    }

    @Test
    void removeFromCartAbsentGood() {
        Cart one = new Cart(userOne);

        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            one.removeFromCart(radio);
        });
        assertNotNull(thrown.getMessage());
    }

}