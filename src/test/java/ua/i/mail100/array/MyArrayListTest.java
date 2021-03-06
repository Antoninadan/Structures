package ua.i.mail100.array;

import org.junit.jupiter.api.Test;
import ua.i.mail100.array.MyArrayList;

import static org.junit.jupiter.api.Assertions.*;

//TODO
//ExceptedException, SystemOutRule(outer)
class MyArrayListTest {

    @Test
    void addValue() {
        MyArrayList one = new MyArrayList(4);
        one.add(10);
        one.add(11);

        assertEquals(10, one.getArray()[0]);
        assertEquals(11, one.getArray()[1]);
        assertEquals(0, one.getArray()[2]);
        assertEquals(0, one.getArray()[3]);
        assertEquals(2, one.getIndex());
    }

    @Test
    void addValueOverload() {
        MyArrayList one = new MyArrayList(1);
        one.add(10);
        assertEquals(1, one.getSize());

        one.add(11);
        assertEquals(2, one.getSize());


        MyArrayList two = new MyArrayList(4);
        two.add(10);
        two.add(11);
        two.add(12);
        two.add(13);
        two.add(14);

        assertEquals(8, two.getSize());
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

        assertEquals(10, one.getArray()[0]);
        assertEquals(11, one.getArray()[1]);
        assertEquals(1, one.getArray()[2] );
        assertEquals(2,one.getArray()[3]);
        assertEquals(0, one.getArray()[4]);
        assertEquals(4, one.getIndex());
    }

    @Test
    void addArrayOverload() {
        MyArrayList one = new MyArrayList(2);
        one.add(10);
        one.add(11);
        MyArrayList two = new MyArrayList(1);
        two.add(11);
        one.add(two);

        assertEquals(5, one.getSize());

        MyArrayList three = new MyArrayList(3);
        three.add(10);
        three.add(11);
        MyArrayList four = new MyArrayList(2);
        four.add(1);
        four.add(1);
        three.add(four);

        assertEquals(8, three.getSize());
    }

    @Test
    void increaseOnSize() {
        MyArrayList one = new MyArrayList(3);
        one.add(10);
        one.add(11);
        one.increaseOnSize(2);
        one.add(12);

        assertEquals(one.getSize(), 5);
        assertEquals(one.getArray()[0], 10);
        assertEquals(one.getArray()[1], 11);
        assertEquals(one.getArray()[2], 12);
        assertEquals(one.getArray()[3], 0);
        assertEquals(one.getArray()[4], 0);
        assertEquals(one.getIndex(), 3);
    }

    @Test
    void decreaseToSize() {
        MyArrayList one = new MyArrayList(6);
        one.add(10);
        one.add(11);
        one.decreaseToSize(4);

        assertEquals(one.getSize(), 4);
        assertEquals(one.getArray()[0], 10);
        assertEquals(one.getArray()[1], 11);
        assertEquals(one.getArray()[2], 0);
        assertEquals(one.getArray()[3], 0);
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
        assertEquals(one.getArray()[0], 10);
        assertEquals(one.getArray()[1], 11);
        assertEquals(one.getArray()[2], 12);
        assertEquals(one.getArray()[3], 1);
        assertEquals(one.getArray()[4], 0);
        assertEquals(one.getArray()[5], 0);
        assertEquals(one.getIndex(), 4);

        MyArrayList three = new MyArrayList(2);
        three.add(100);

        one.concatenateWith(three);
        assertEquals(one.getSize(), 8);
        assertEquals(one.getArray()[0], 10);
        assertEquals(one.getArray()[1], 11);
        assertEquals(one.getArray()[2], 12);
        assertEquals(one.getArray()[3], 1);
        assertEquals(one.getArray()[4], 100);
        assertEquals(one.getArray()[5], 0);
        assertEquals(one.getArray()[6], 0);
        assertEquals(one.getArray()[7], 0);
        assertEquals(one.getIndex(), 5);

        MyArrayList four = new MyArrayList(1);
        one.concatenateWith(four);
        assertEquals(9, one.getSize());
        assertEquals(one.getArray()[0], 10);
        assertEquals(one.getArray()[1], 11);
        assertEquals(one.getArray()[2], 12);
        assertEquals(one.getArray()[3], 1);
        assertEquals(one.getArray()[4], 100);
        assertEquals(one.getArray()[5], 0);
        assertEquals(one.getArray()[6], 0);
        assertEquals(one.getArray()[7], 0);
        assertEquals(one.getArray()[8], 0);
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
        assertEquals(result.getArray()[0], 11);
        assertEquals(result.getArray()[1], 12);
        assertEquals(result.getArray()[2], 13);
        assertEquals(3, result.getIndex());

        MyArrayList resultTwo = MyArrayList.getArrayCopiedFrom(one, 0, 0);
        assertEquals(resultTwo.getSize(), 1);
        assertEquals(resultTwo.getArray()[0], 10);
        assertEquals(1, resultTwo.getIndex());

        MyArrayList resultThree = MyArrayList.getArrayCopiedFrom(one, 6, 6);
        assertEquals(resultThree.getSize(), 1);
        assertEquals(resultThree.getArray()[0], 0);
        assertEquals(0, resultThree.getIndex());

        MyArrayList resultFour = MyArrayList.getArrayCopiedFrom(one, 4, 6);
        assertEquals(resultFour.getSize(), 3);
        assertEquals(resultFour.getArray()[0], 0);
        assertEquals(resultFour.getArray()[1], 0);
        assertEquals(resultFour.getArray()[2], 0);
        assertEquals(0, resultFour.getIndex());


        one.add(14);
        one.add(15);

        MyArrayList resultFive = MyArrayList.getArrayCopiedFrom(one, 5, 6);
        assertEquals(2, resultFive.getSize());
        assertEquals(15, resultFive.getArray()[0]);
        assertEquals(0, resultFive.getArray()[1]);
        assertEquals(1, resultFive.getIndex());
    }


    @Test
    void delete() {
        MyArrayList one = new MyArrayList(5);
        one.add(10);
        one.add(11);
        one.add(12);
        one.add(13);

        one.deleteByIndex(2);
        assertEquals(one.getSize(), 4);
        assertEquals(one.getArray()[0], 10);
        assertEquals(one.getArray()[1], 11);
        assertEquals(one.getArray()[2], 13);
        assertEquals(one.getArray()[3], 0);
        assertEquals(3, one.getIndex());


        MyArrayList two = new MyArrayList(5);
        two.add(10);
        two.add(11);
        two.add(12);
        two.add(13);

        two.deleteByIndex(0);
        assertEquals(two.getSize(), 4);
        assertEquals(two.getArray()[0], 11);
        assertEquals(two.getArray()[1], 12);
        assertEquals(two.getArray()[2], 13);
        assertEquals(two.getArray()[3], 0);
        assertEquals(3, two.getIndex());


        MyArrayList three = new MyArrayList(5);
        three.add(10);
        three.add(11);
        three.add(12);
        three.add(13);
        three.add(14);

        three.deleteByIndex(4);
        assertEquals(three.getSize(), 4);
        assertEquals(three.getArray()[0], 10);
        assertEquals(three.getArray()[1], 11);
        assertEquals(three.getArray()[2], 12);
        assertEquals(three.getArray()[3], 13);
        assertEquals(4, three.getIndex());


        MyArrayList four = new MyArrayList(2);
        four.add(10);
        four.add(11);

        four.deleteByIndex(1);
        assertEquals(four.getSize(), 1);
        assertEquals(four.getArray()[0], 10);
        assertEquals(1, four.getIndex());
    }

    @Test
    void deleteErrorWrongIndex() {
        MyArrayList one = new MyArrayList(5);
        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            one.deleteByIndex(6);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void deleteErrorLastElement() {
        MyArrayList one = new MyArrayList(1);
        Throwable thrown = assertThrows(RuntimeException.class, () -> {
            one.deleteByIndex(6);
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
        assertEquals(one.getArray()[0], 10);
        assertEquals(one.getArray()[1], 11);
        assertEquals(one.getArray()[2], 100);
        assertEquals(one.getArray()[3], 13);
        assertEquals(one.getArray()[4], 0);
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
        assertEquals(-11, one.getArray()[0]);
        assertEquals(-1, one.getArray()[1]);
        assertEquals(0, one.getArray()[2]);
        assertEquals(10, one.getArray()[3]);
        assertEquals(100, one.getArray()[4]);
        assertEquals(0, one.getArray()[5]);
        assertEquals(0, one.getArray()[6]);
        assertEquals(0, one.getArray()[7]);
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

        assertEquals(0, one.getArray()[5]);
        assertEquals(0, one.getArray()[6]);
        assertEquals(0, one.getArray()[7]);
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

        assertEquals(0, one.getArray()[0]);
        assertEquals(1, one.getArray()[1]);
        assertEquals(2, one.getArray()[2]);
        assertEquals(3, one.getArray()[3]);
        assertEquals(4, one.getArray()[4]);
        assertEquals(5, one.getArray()[5]);
        assertEquals(0, one.getArray()[6]);
        assertEquals(0, one.getArray()[7]);
        assertEquals(0, one.getArray()[8]);
        assertEquals(0, one.getArray()[9]);

    }

}

//test:
//error - отдельно?
//как настроить, чтобы все запускались?
//почему бывают запреты?