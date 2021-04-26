import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("The first number: ");
        int firstNumber = myInput.nextInt();
        System.out.println("The second number: ");
        int secondNumber = myInput.nextInt();

        int thirdNumber = firstNumber;
        firstNumber = secondNumber;
        secondNumber = thirdNumber;

        System.out.printf("First number: %d\n", firstNumber);
        System.out.printf("Second number: %d\n", secondNumber);
    }
}
