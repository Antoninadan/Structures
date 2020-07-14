package ua.i.mail100.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.i.mail100.array.MyArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @BeforeEach
    void setUp() {
    }


    @Test
    void addValue() {
        MyArrayList one = new MyArrayList(4);
        one.add(10);
        one.add(11);

        assertEquals(10, one.getMas()[0]);
        assertEquals(11, one.getMas()[1]);
        assertEquals(0, one.getMas()[2]);
        assertEquals(0, one.getMas()[3]);
        assertEquals(2, one.getIndex());
    }

    @Test
    void addValueOverload() {
        MyArrayList two = new MyArrayList(1);
        two.add(10);

        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            two.add(11);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void addArray() {
        MyArrayList one = new MyArrayList(5);
        one.add(10);
        one.add(11);
        MyArrayList two = new MyArrayList(6);
        two.add(1);
        two.add(2);
        one.add(two);

        assertEquals(10, one.getMas()[0]);
        assertEquals(11, one.getMas()[1]);
        assertEquals(one.getMas()[2], 1);
        assertEquals(one.getMas()[3], 2);
        assertEquals(one.getMas()[4], 0);
        assertEquals(one.getIndex(), 4);
    }

    @Test
    void addArrayErrorOverload() {
        MyArrayList one = new MyArrayList(2);
        one.add(10);
        one.add(11);
        MyArrayList two = new MyArrayList(1);
        two.add(11);
        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            one.add(two);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void addArrayErrorOverload2() {
        MyArrayList one = new MyArrayList(3);
        one.add(10);
        one.add(11);
        MyArrayList two = new MyArrayList(2);
        two.add(1);
        two.add(1);
        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            one.add(two);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void increaseOnSize() {
        MyArrayList one = new MyArrayList(3);
        one.add(10);
        one.add(11);
        one.increaseOnSize(2);
        one.add(12);

        assertEquals(one.getSize(), 5);
        assertEquals(one.getMas()[0], 10);
        assertEquals(one.getMas()[1], 11);
        assertEquals(one.getMas()[2], 12);
        assertEquals(one.getMas()[3], 0);
        assertEquals(one.getMas()[4], 0);
        assertEquals(one.getIndex(), 3);
    }

    @Test
    void decreaseToSize() {
        MyArrayList one = new MyArrayList(6);
        one.add(10);
        one.add(11);
        one.decreaseToSize(4);

        assertEquals(one.getSize(), 4);
        assertEquals(one.getMas()[0], 10);
        assertEquals(one.getMas()[1], 11);
        assertEquals(one.getMas()[2], 0);
        assertEquals(one.getMas()[3], 0);
        assertEquals(one.getIndex(), 2);
    }

    @Test
    void decreaseToSizeError() {
        MyArrayList one = new MyArrayList(3);
        one.add(10);
        one.add(11);

        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            one.decreaseToSize(1);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void concatenateWith() {
        MyArrayList one = new MyArrayList(4);
        one.add(10);
        one.add(11);
        one.add(12);
        MyArrayList two = new MyArrayList(2);
        two.add(1);

        one.concatenateWith(two);
        assertEquals(one.getSize(), 6);
        assertEquals(one.getMas()[0], 10);
        assertEquals(one.getMas()[1], 11);
        assertEquals(one.getMas()[2], 12);
        assertEquals(one.getMas()[3], 1);
        assertEquals(one.getMas()[4], 0);
        assertEquals(one.getMas()[5], 0);
        assertEquals(one.getIndex(), 4);

        MyArrayList three = new MyArrayList(2);
        three.add(100);

        one.concatenateWith(three);
        assertEquals(one.getSize(), 8);
        assertEquals(one.getMas()[0], 10);
        assertEquals(one.getMas()[1], 11);
        assertEquals(one.getMas()[2], 12);
        assertEquals(one.getMas()[3], 1);
        assertEquals(one.getMas()[4], 100);
        assertEquals(one.getMas()[5], 0);
        assertEquals(one.getMas()[6], 0);
        assertEquals(one.getMas()[7], 0);
        assertEquals(one.getIndex(), 5);

        MyArrayList four = new MyArrayList(1);
        one.concatenateWith(four);
        assertEquals(9, one.getSize());
        assertEquals(one.getMas()[0], 10);
        assertEquals(one.getMas()[1], 11);
        assertEquals(one.getMas()[2], 12);
        assertEquals(one.getMas()[3], 1);
        assertEquals(one.getMas()[4], 100);
        assertEquals(one.getMas()[5], 0);
        assertEquals(one.getMas()[6], 0);
        assertEquals(one.getMas()[7], 0);
        assertEquals(one.getMas()[8], 0);
        assertEquals(one.getIndex(), 5);
    }

    @Test
    void getArrayCopiedFrom() {
        MyArrayList one = new MyArrayList(7);
        one.add(10);
        one.add(11);
        one.add(12);
        one.add(13);

        MyArrayList result = MyArrayList.getArrayCopiedFrom(one, 1, 3);
        assertEquals(result.getSize(), 3);
        assertEquals(result.getMas()[0], 11);
        assertEquals(result.getMas()[1], 12);
        assertEquals(result.getMas()[2], 13);
        assertEquals(3, result.getIndex());

        MyArrayList resultTwo = MyArrayList.getArrayCopiedFrom(one, 0, 0);
        assertEquals(resultTwo.getSize(), 1);
        assertEquals(resultTwo.getMas()[0], 10);
        assertEquals(1, resultTwo.getIndex());

        MyArrayList resultThree = MyArrayList.getArrayCopiedFrom(one, 6, 6);
        assertEquals(resultThree.getSize(), 1);
        assertEquals(resultThree.getMas()[0], 0);
        assertEquals(0, resultThree.getIndex());

        MyArrayList resultFour = MyArrayList.getArrayCopiedFrom(one, 4, 6);
        assertEquals(resultFour.getSize(), 3);
        assertEquals(resultFour.getMas()[0], 0);
        assertEquals(resultFour.getMas()[1], 0);
        assertEquals(resultFour.getMas()[2], 0);
        assertEquals(0, resultFour.getIndex());


        one.add(14);
        one.add(15);

        MyArrayList resultFive = MyArrayList.getArrayCopiedFrom(one, 5, 6);
        assertEquals(2, resultFive.getSize());
        assertEquals(15, resultFive.getMas()[0]);
        assertEquals(0, resultFive.getMas()[1]);
        assertEquals(1, resultFive.getIndex());
    }


    @Test
    void delete() {
        MyArrayList one = new MyArrayList(5);
        one.add(10);
        one.add(11);
        one.add(12);
        one.add(13);

        one.delete(2);
        assertEquals(one.getSize(), 4);
        assertEquals(one.getMas()[0], 10);
        assertEquals(one.getMas()[1], 11);
        assertEquals(one.getMas()[2], 13);
        assertEquals(one.getMas()[3], 0);
        assertEquals(3, one.getIndex());


        MyArrayList two = new MyArrayList(5);
        two.add(10);
        two.add(11);
        two.add(12);
        two.add(13);

        two.delete(0);
        assertEquals(two.getSize(), 4);
        assertEquals(two.getMas()[0], 11);
        assertEquals(two.getMas()[1], 12);
        assertEquals(two.getMas()[2], 13);
        assertEquals(two.getMas()[3], 0);
        assertEquals(3, two.getIndex());


        MyArrayList three = new MyArrayList(5);
        three.add(10);
        three.add(11);
        three.add(12);
        three.add(13);
        three.add(14);

        three.delete(4);
        assertEquals(three.getSize(), 4);
        assertEquals(three.getMas()[0], 10);
        assertEquals(three.getMas()[1], 11);
        assertEquals(three.getMas()[2], 12);
        assertEquals(three.getMas()[3], 13);
        assertEquals(4, three.getIndex());


        MyArrayList four = new MyArrayList(2);
        four.add(10);
        four.add(11);

        four.delete(1);
        assertEquals(four.getSize(), 1);
        assertEquals(four.getMas()[0], 10);
        assertEquals(1, four.getIndex());
    }

    @Test
    void deleteErrorWrongIndex() {
        MyArrayList one = new MyArrayList(5);
        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            one.delete(6);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void deleteErrorLastElement() {
        MyArrayList one = new MyArrayList(1);
        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            one.delete(6);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void change() {
        MyArrayList one = new MyArrayList(5);
        one.add(10);
        one.add(11);
        one.add(12);
        one.add(13);

        one.change(2, 100);
        assertEquals(one.getSize(), 5);
        assertEquals(one.getMas()[0], 10);
        assertEquals(one.getMas()[1], 11);
        assertEquals(one.getMas()[2], 100);
        assertEquals(one.getMas()[3], 13);
        assertEquals(one.getMas()[4], 0);
        assertEquals(4, one.getIndex());
    }


    @Test
    void changeErrorWrongIndex() {
        MyArrayList one = new MyArrayList(5);
        one.add(10);
        one.add(11);

        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            one.change(4, 100);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void toStringTest() {
        MyArrayList one = new MyArrayList(5);
        one.add(10);
        one.add(11);

        String expected = "size=5: [10, 11, 0, 0, 0]";
        assertEquals(expected, one.toString());
    }


    @Test
    void toStringReverseTest() {
        MyArrayList one = new MyArrayList(5);
        one.add(10);
        one.add(11);

        String expected = "Reverse, size=5: [0, 0, 0, 11, 10]";
        assertEquals(expected, one.toStringReverse());
    }

    void sort() {
        MyArrayList one = new MyArrayList(8);
        one.add(10);
        one.add(-11);
        one.add(100);
        one.add(-1);
        one.add(0);

        one.sort();
        assertEquals(-11, one.getMas()[0]);
        assertEquals(-1, one.getMas()[1]);
        assertEquals(0, one.getMas()[2]);
        assertEquals(10, one.getMas()[3]);
        assertEquals(100, one.getMas()[4]);
        assertEquals(0, one.getMas()[5]);
        assertEquals(0, one.getMas()[6]);
        assertEquals(0, one.getMas()[7]);
    }

    void saerch() {
        MyArrayList one = new MyArrayList(8);
        one.add(10);
        one.add(-11);
        one.add(0);
        one.add(-1);
        one.add(10);

        assertEquals(2, one.seacrh(0));
        assertEquals(4, one.seacrh(10));
        assertEquals(-1, one.seacrh(8898));
    }

    void shuffle() {
        MyArrayList one = new MyArrayList(8);
        one.add(0);
        one.add(1);
        one.add(2);
        one.add(3);
        one.add(4);

        one.shuffle();

        assertEquals(0, one.getMas()[5]);
        assertEquals(0, one.getMas()[6]);
        assertEquals(0, one.getMas()[7]);
    }

    void deleteDuplicates() {
        MyArrayList one = new MyArrayList(10);
        one.add(0);
        one.add(1);
        one.add(2);
        one.add(1);
        one.add(3);
        one.add(4);
        one.add(0);
        one.add(1);
        one.add(5);

        one.deleteDuplicates();

        assertEquals(0, one.getMas()[0]);
        assertEquals(1, one.getMas()[1]);
        assertEquals(2, one.getMas()[2]);
        assertEquals(3, one.getMas()[3]);
        assertEquals(4, one.getMas()[4]);
        assertEquals(5, one.getMas()[5]);
        assertEquals(0, one.getMas()[6]);
        assertEquals(0, one.getMas()[7]);
        assertEquals(0, one.getMas()[8]);
        assertEquals(0, one.getMas()[9]);

    }

}

//test:
//error - отдельно?
//как настроить, чтобы все запускались?
//почему бывают запреты?