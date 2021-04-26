import java.util.Scanner;

public class TaskSix {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("The Celsius degree : ");
        double celsiusDegree = myInput.nextDouble();

        double fahrenheit = celsiusDegree * 9 / 5 + 32;
        System.out.printf("The Fahrenheit degree: %f", fahrenheit);
    }
}
