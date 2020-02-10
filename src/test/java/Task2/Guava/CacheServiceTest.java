package Task2.Guava;

import Task2.Java.CacheServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CacheServiceTest {

    CacheServiceImpl cacheService = new CacheServiceImpl(10);

    @Before
    public void init() {
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

        CacheServiceImpl.CacheEntry entry = cacheService.get(0);
        String result = entry.getString();

        assertEquals(expected, result);
    }

    @Test
    public void putTest() {
        cacheService.put(10, "message10");

        assertTrue(cacheService.getCacheMap().containsKey(10)
                && cacheService.getCacheMap().get(10).getString().equals("message10")
                && cacheService.getCacheMap().size() == 10);
    }
}