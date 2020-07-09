package ua.i.mail100.figures;

import java.io.IOException;

public abstract class Figure implements Calculatable {
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

    @Override
    public Double calculateSquare() {
        return side * height;
    }

    private int getMessage() {
        try {
            // ругнется, что не вылетит ни одно из представленных exception
            return 1;
        } catch (IllegalArgumentException | NullPointerException e) {

        } finally {
            // прикольная ситуация, я не знаю, как будет.... предположение - ругнется, что не сможет дойти до finally
            return 2;
        }

    }

}
