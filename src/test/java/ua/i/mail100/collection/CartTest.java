package ua.i.mail100.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.i.mail100.collection.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
    Good charge2;

    @BeforeEach
    void setUp() {
        userOne = new User("Vasya");
        userTwo = new User("Masha");

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


        radio = new Good("radio", "Mayak", dateOne, 1000, 4, categoryNodeFour);
        tv = new Good("TV", "Gorizont", dateTwo, 2000, 100, categoryNodeFive);
        remote = new Good("remote control", "LG", dateThree, 300, 20, categoryNodeSix);
        battery = new Good("battery", "Duracel", dateFour, 50, 150, categoryNodeSeven);
        a7 = new Good("A7", "Samsung", dateFive, 20000, 200, categoryNodeTwo);
        charge = new Good("Charge Type S", "Samsung", dateFive, 200, 35, categoryNodeThree);
        charge2 = new Good("Charge", "LG", dateFive, 170, 40, categoryNodeThree);
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
    void getRelatedGoodsTo() {
        Cart one = new Cart(userOne);
        one.addToCart(a7, 1);
        one.addToCart(remote, 1);
        one.addToCart(charge, 1);
        one.addToCart(charge2, 1);

        assertEquals(1, one.getGoods().get(a7));
        assertEquals(1, one.getGoods().get(remote));
        assertEquals(1, one.getGoods().get(charge));
        assertEquals(1, one.getGoods().get(charge2));

        List<Good> relatedGoods = one.getRelatedGoodsTo(a7);
        assertTrue(relatedGoods.contains(charge));
        assertTrue(relatedGoods.contains(charge2));
        assertFalse(relatedGoods.contains(remote));
        assertFalse(relatedGoods.contains(a7));
    }

    @Test
    void relatedGoodsRemove() {
        Cart one = new Cart(userOne);
        one.addToCart(a7, 1);
        one.addToCart(remote, 1);
        one.addToCart(charge, 1);
        one.addToCart(charge2, 1);

        assertEquals(1, one.getGoods().get(a7));
        assertEquals(1, one.getGoods().get(remote));
        assertEquals(1, one.getGoods().get(charge));
        assertEquals(1, one.getGoods().get(charge2));
        assertEquals(34, charge.getAmount());
        assertEquals(39, charge2.getAmount());

        one.relatedGoodsRemove(a7);
        assertFalse(one.getGoods().containsKey(charge));
        assertFalse(one.getGoods().containsKey(charge2));
        assertTrue(one.getGoods().containsKey(a7));
        assertTrue(one.getGoods().containsKey(remote));
        assertEquals(35, charge.getAmount());
        assertEquals(40, charge2.getAmount());
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



        Cart two = new Cart(userOne);
        two.addToCart(a7, 1);
        two.addToCart(remote, 1);
        two.addToCart(charge, 1);
        two.addToCart(charge2, 1);

        assertEquals(1, two.getGoods().get(a7));
        assertEquals(1, two.getGoods().get(remote));
        assertEquals(1, two.getGoods().get(charge));
        assertEquals(1, two.getGoods().get(charge2));
        assertEquals(199, a7.getAmount());
        assertEquals(34, charge.getAmount());
        assertEquals(39, charge2.getAmount());

        two.removeFromCart(a7);
        assertFalse(two.getGoods().containsKey(charge));
        assertFalse(two.getGoods().containsKey(charge2));
        assertFalse(two.getGoods().containsKey(a7));
        assertTrue(two.getGoods().containsKey(remote));
        assertEquals(200, a7.getAmount());
        assertEquals(35, charge.getAmount());
        assertEquals(40, charge2.getAmount());
    }

    @Test
    void removeFromCartAbsentGood() {
        Cart one = new Cart(userOne);

        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            one.removeFromCart(radio);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void getTotal() {
        Cart one = new Cart(userOne);
        one.addToCart(a7, 1);
        one.addToCart(remote, 2);
        one.addToCart(charge, 3);
        one.addToCart(charge2, 4);

        assertEquals(1, one.getGoods().get(a7)); // 1* 20000
        assertEquals(2, one.getGoods().get(remote)); // 2 * 300
        assertEquals(3, one.getGoods().get(charge)); // 3 * 200
        assertEquals(4, one.getGoods().get(charge2)); // 4 * 170

        int expected = 1* 20000 + 2 * 300 + 3 * 200 + 4 * 170;
        assertEquals(expected, one.getTotal());
    }



}