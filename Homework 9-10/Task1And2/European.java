package Task1And2;

public class European extends BasePerson implements Person {

    public European(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void sayHello() {
        System.out.println(this.getName() + " says Hi!");
    }
}
