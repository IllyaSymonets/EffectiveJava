package Task1.Item41;

public class GoodPracticeAreaCounter {

    public double countSquareArea(Square square) {
        return Math.pow(square.sideA, 2);
    }

    public double countRectangleArea(Rectangle rectangle) {
        return rectangle.sideA * rectangle.sideB;
    }
}
