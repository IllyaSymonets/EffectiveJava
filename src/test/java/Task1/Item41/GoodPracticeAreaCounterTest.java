package Task1.Item41;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoodPracticeAreaCounterTest {

    GoodPracticeAreaCounter areaCounter = new GoodPracticeAreaCounter();

    @Test
    public void countSquareAreaTest() {
        double expected = 25.0;
        Square square=new Square(5);

        double result = areaCounter.countSquareArea(square);

        Assert.assertEquals(expected, result, 0.001);
    }

    @Test
    public void countRectangleAreaTest() {
        double expected = 25.0;
        Rectangle square=new Rectangle(5, 5);

        double result = areaCounter.countRectangleArea(square);

        Assert.assertEquals(expected, result, 0.001);
    }
}