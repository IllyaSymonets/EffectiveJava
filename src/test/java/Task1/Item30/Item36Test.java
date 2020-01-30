package Task1.Item30;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class Item36Test {

    @Test
    public void Test(){
        BigDecimal expected = BigDecimal.valueOf(250.0);

        BigDecimal result = Price.WALLET.getPrice().add(Price.BELT.getPrice());

        Assert.assertEquals(expected, result);
    }
}
