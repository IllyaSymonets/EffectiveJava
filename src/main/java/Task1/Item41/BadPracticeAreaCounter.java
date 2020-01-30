package Task1.Item41;

public class BadPracticeAreaCounter {

    public double countArea(Square square) {
        return Math.pow(square.sideA, 2);
    }

    public double countArea(Rectangle rectangle) {
        return rectangle.sideA * rectangle.sideB;
    }
}
