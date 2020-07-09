package ua.i.mail100.shapes;

import ua.i.mail100.shapes.for_test.Shape;

public class Circle extends Shape {

    public Circle() {
        super();
        shareType = ShareType.CIRCLE;
    }

    public void draw() {
        System.out.println("draw circle");
    }

}
