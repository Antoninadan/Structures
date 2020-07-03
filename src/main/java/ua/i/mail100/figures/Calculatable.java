package ua.i.mail100.figures;

public interface Calculatable {
    Double calculateSquare();

    default void print(Object object){
        System.out.println(object.getClass().getName());
    }



}
