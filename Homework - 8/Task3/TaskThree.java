package Task3;

public class TaskThree {
    public static void main(String[] args) {
        Circle circle1 = new Circle(3);
        System.out.println(circle1.toString());

        System.out.println("Area: " + circle1.getArea());
        System.out.println("Circumference: " + circle1.getCircumference());
    }
}
