public class Cat extends Animal {

    public Cat(int age, String name, String gender) {
        super(age, name, gender);
    }

    @Override
    public void makeSound() {
        System.out.println("Mrrr..");
    }
}
