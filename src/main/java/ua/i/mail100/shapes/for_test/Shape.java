package ua.i.mail100.shapes.for_test;

import ua.i.mail100.shapes.ShareType;

public abstract class Shape {
    // -> private
    protected ShareType shareType;

    public ShareType getShareType() {
        return shareType;
    }

    public abstract void draw();
}

/*
* private - visiblity only inside class
* package - private - visiblity only package
* protected - visiblity only package + subclasses
* public - visiblity anywhere
*
* */

