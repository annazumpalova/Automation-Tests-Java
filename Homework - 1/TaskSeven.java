import java.util.Scanner;

public class TaskSeven {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("The Fahrenheit degree : ");
        double fahrenheit  = myInput.nextDouble();

        double celsiusDegree = (fahrenheit - 32) * 5/9;
        System.out.printf("The Celsius degree: %f", celsiusDegree);
    }
}
