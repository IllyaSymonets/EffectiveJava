package Task1.item52;

import org.junit.Assert;
import org.junit.Test;

public class AreaCounterTest {

    AreaCounter areaCounter = new AreaCounter();

    @Test
    public void countRectangleAreaTest() {
        double expected = 25.0;
        AreaCountable rectangle = new Rectangle(5, 5);

        double result= areaCounter.countArea(rectangle);

        Assert.assertEquals(expected, result, 0.001);
    }

    @Test
    public void countSquareAreaTest() {
        double expected = 25.0;
        AreaCountable square = new Square(5);

        double result= areaCounter.countArea(square);

        Assert.assertEquals(expected, result, 0.001);
    }

    @Test
    public void countCircleAreaTest() {
        double expected = 78.5;
        AreaCountable circle = new Circle(5);

        double result= areaCounter.countArea(circle);

        Assert.assertEquals(expected, result, 0.05);
    }
}