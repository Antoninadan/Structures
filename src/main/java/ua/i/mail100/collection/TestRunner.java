package ua.i.mail100.collection;

public class TestRunner {
    public static void main(String[] args) {

   MyArrayList one = new MyArrayList(4);
        one.add(10);
        one.add(11);
        one.add(12);
        MyArrayList two = new MyArrayList(2);
        two.add(1);

        one.concatenateWith(two);
        System.out.println("one - " + one);

        MyArrayList three = new MyArrayList(2);
        three.add(100);

        one.concatenateWith(three);
        System.out.println("one - " + one);




//        // overload
//        MyArrayList three = new MyArrayList(1);
//        three.add(10);
//        three.add(11);



    }
}
