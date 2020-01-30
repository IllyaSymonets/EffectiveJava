package Task1.Item16;

public class GreetingWrapper extends Greeting {

    Greeting greeting;

    public GreetingWrapper(Greeting greeting) {
        this.greeting = greeting;
    }

    @Override
    public StringBuilder getGreeting() {
        return greeting.getGreeting();
    }

    @Override
    public StringBuilder getUserGreeting(StringBuilder username) {
        return greeting.getUserGreeting(username);
    }
}
