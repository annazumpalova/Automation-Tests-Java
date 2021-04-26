public class Tomcat extends Animal {

    public Tomcat(int age, String name, String gender) {
        super(age, name, gender);
    }

    @Override
    public void makeSound() {
        System.out.println("Miaaaaul...");
    }
}
