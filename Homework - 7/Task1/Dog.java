public class Dog extends Animal {

    public Dog(int age, String name, String gender) {
        super(age, name, gender);
    }

    @Override
    public void makeSound() {
        System.out.println("Bau bau");
    }
}
