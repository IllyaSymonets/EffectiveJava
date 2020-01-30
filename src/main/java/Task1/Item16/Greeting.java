package Task1.Item16;

public class Greeting {
    public StringBuilder getGreeting() {
        return new StringBuilder("Hello ");
    }

    public StringBuilder getUserGreeting(StringBuilder username) {
        return username.append(" ").append(getGreeting());
    }
}
