public class Exercise1 {
    public static void main(String[] args) {

        Animal[] arr = new Animal[5];
        arr[0] = new Dog(4, "Sara", "F");
        arr[1] = new Frog(2, "Froggy", "M");
        arr[2] = new Cat(8, "Bella", "F");
        arr[3] = new Kitten(1, "Tommy", "M");
        arr[4] = new Tomcat(9, "Michael", "M");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Object " + (i + 1));
            System.out.println("Age: " + arr[i].age);
            System.out.println("Name: " + arr[i].name);
            System.out.println("Gender: " + arr[i].gender);
            arr[i].makeSound();
            System.out.println("\n");
        }
    }
}
