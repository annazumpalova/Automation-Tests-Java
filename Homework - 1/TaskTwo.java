import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("The first number: ");
        int firstNumber = myInput.nextInt();
        System.out.println("The second number: ");
        int secondNumber = myInput.nextInt();

        int sum = firstNumber + secondNumber;
        int diff = firstNumber - secondNumber;
        int rest = firstNumber % secondNumber;
        int devision = firstNumber / secondNumber;

        System.out.printf("Sum = %d\n", sum);
        System.out.printf("Difference = %d\n", diff);
        System.out.printf("Rest = %d\n", rest);
        System.out.printf("Devision = %d\n", devision);
    }
}
