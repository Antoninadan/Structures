package ua.i.mail100.shapes;

public abstract class Shape {
    protected ShareType shareType;

    public ShareType getShareType() {
        return shareType;
    }

    public abstract void draw();
}
