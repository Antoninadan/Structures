package ua.i.mail100.shapes;

public class Square extends Shape {

    public Square() {
        super();
        shareType = ShareType.SQUARE;
    }

    public void draw() {
        System.out.println("draw square");
    }
}
