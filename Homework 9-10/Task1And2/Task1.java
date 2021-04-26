package Task1And2;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Bulgarian("Pesho"));
        persons.add(new European("George"));
        persons.add(new Chinese("Djeky"));

        for (Person person : persons) {
            print(person);
        }
    }

    private static void print(Person person) {
        person.sayHello();
    }
}

