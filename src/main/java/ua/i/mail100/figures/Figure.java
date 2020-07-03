package ua.i.mail100.figures;

public abstract class Figure implements Calculatable{
    protected Double side;
    protected Double height;

    public Figure(Double side, Double height) {
        this.side = side;
        this.height = height;
    }

    public Double getSide() {
        return side;
    }

    public void setSide(Double side) {
        this.side = side;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
