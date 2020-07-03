package ua.i.mail100.figures;

public class Triangle extends Figure{
    public Triangle(Double side, Double height) {
        super(side, height);
    }

    @Override
    public Double calculateSquare() {
        return side * height / 2;
    }
}
