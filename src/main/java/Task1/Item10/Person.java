package Task1.Item10;

import lombok.ToString;

import java.util.Date;
import java.util.List;

@ToString
public class Person {

    String name;
    String surname;
    int age;
    Gender gender;
    List<Role> roles;
    String Address;
    Date dateOfBirth;

}
