package Task5;

public class Task5 {
    public static void main(String[] args) {
        Animal cat = new Cat("Oscar", "Whiskas");
        Animal dog = new Dog("Rocky", "Meat");

        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());
    }
}
