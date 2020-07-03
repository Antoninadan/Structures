package ua.i.mail100.figures;

public class Romb extends Figure{
    public Romb(Double side, Double height) {
        super(side, height);
    }

    @Override
    public Double calculateSquare() {
        return side * height;
    }
}
