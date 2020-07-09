package ua.i.mail100.shapes;

public abstract class Shape {
    protected ShareType shareType;

    public ShareType getShareType() {
        return shareType;
    }


    public void draw() {
        if (getShareType() == ShareType.SQUARE) {
         //   drawSquare();
        } else {
         //   drawCircle();
        }
    }

    //others methods

}
