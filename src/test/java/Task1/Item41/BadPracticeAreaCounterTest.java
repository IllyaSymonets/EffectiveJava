package Task1.Item41;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BadPracticeAreaCounterTest {

    BadPracticeAreaCounter areaCounter = new BadPracticeAreaCounter();

    @Test
    public void countSquareAreaTest() {
        double expected = 0.0;
        Rectangle square=new Square(5);

        double result = areaCounter.countArea(square);

        Assert.assertEquals(expected, result, 0.001);
    }

    @Test
    public void countRectangleAreaTest() {
        double expected = 25.0;
        Rectangle square=new Rectangle(5, 5);

        double result = areaCounter.countArea(square);

        Assert.assertEquals(expected, result, 0.001);
    }
}