package ua.i.mail100.figures;

public interface Calculatable {
    Double calculateSquare();

    default void print(){
        System.out.println(this.getClass().getSimpleName());
    }



}
