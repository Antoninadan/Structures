package ua.i.mail100.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.i.mail100.collection.Category;
import ua.i.mail100.collection.CategoryNode;
import ua.i.mail100.collection.Good;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class GoodTest {
    Good radio;
    Good tv;
    Good remote;
    Good battery;
    Good a7;
    Good charge;

    @BeforeEach
    void setUp() {
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

    }

    @Test
    void toStringTest() {
        String expected = "radio Mayak, 2020.01.31";
        assertEquals(expected, radio.toString());
    }

    @Test
    void toStringShop() {
        String expected = "PHONES_AND_OTHER/PHONES/CHARGE: Charge Type S Samsung, 2020.05.10, price = 200, amount = 35";
        assertEquals(expected, charge.toStringShop());
    }
}