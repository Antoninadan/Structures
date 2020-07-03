package ua.i.mail100.figures;

public class FiguresRunner {
    public static void main(String[] args) {
        Parallelogram parallelogramOne = new Parallelogram(12.00, 13.00);
        Triangle triangleOne = new Triangle(12.00, 13.00);
        Romb rombOne = new Romb(12.00, 13.00);

        System.out.println(parallelogramOne.calculateSquare());
        System.out.println(triangleOne.calculateSquare());
        System.out.println(rombOne.calculateSquare());

        parallelogramOne.print(parallelogramOne);
    }
}
