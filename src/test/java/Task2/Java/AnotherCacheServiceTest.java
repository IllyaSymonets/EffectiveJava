package Task2.Java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AnotherCacheServiceTest {

    AnotherCacheService cacheService = new AnotherCacheService(10);

    @Before
    public void init() throws InterruptedException {
        cacheService.put(0, "message0");
        cacheService.put(1, "message1");
        cacheService.put(2, "message2");
        cacheService.put(3, "message3");
        cacheService.put(4, "message4");
        cacheService.put(5, "message5");
        cacheService.put(6, "message6");
        cacheService.put(7, "message7");
        cacheService.put(8, "message8");
        cacheService.put(9, "message9");
    }

    @Test
    public void getTest() {
        String expected = "message0";

        String result = cacheService.get(0).getString();

        assertEquals(expected, result);
    }

    @Test
    public void putTest() throws InterruptedException {

        cacheService.put(10, "message10");

        assertTrue(cacheService.getCacheMap().containsKey(10)
            && cacheService.getCacheMap().get(10).getString().equals("message10")
            && cacheService.getCacheMap().size() <= 10);
    }
}