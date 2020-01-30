package Task1.Item16;

public class OfficialGreeting extends GreetingWrapper {

    private StringBuilder role;

    public OfficialGreeting(Greeting greeting) {
        super(greeting);
    }

    @Override
    public StringBuilder getGreeting() {
        return super.getGreeting().append(role);
    }

    @Override
    public StringBuilder getUserGreeting(StringBuilder username) {
        return role.append(" ").append(super.getUserGreeting(username));
    }

    public void setRole(StringBuilder role) {
        this.role = role;
    }
}
