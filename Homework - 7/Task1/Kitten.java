public class Kitten extends Animal {

    public Kitten(int age, String name, String gender) {
        super(age, name, gender);
    }

    @Override
    public void makeSound() {
        System.out.println("Miual miual...");
    }
}
