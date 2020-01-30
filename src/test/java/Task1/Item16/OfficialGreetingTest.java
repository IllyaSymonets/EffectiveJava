package Task1.Item16;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class OfficialGreetingTest {

    OfficialGreeting officialGreeting = new OfficialGreeting(new Greeting());

    @Before
    public void init() {
        officialGreeting.setRole(new StringBuilder("role"));
    }

    @Test
    public void getGreetingTest() {

        StringBuilder expected = new StringBuilder("Hello role");

        StringBuilder result = officialGreeting.getGreeting();

        Assert.assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void getUserGreeting() {
        StringBuilder expected = new StringBuilder("role username Hello ");

        StringBuilder result = officialGreeting.getUserGreeting(new StringBuilder("username"));

        Assert.assertEquals(expected.toString(), result.toString());
    }
}