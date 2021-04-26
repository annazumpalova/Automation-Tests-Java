import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        System.out.println("The A number: ");
        double numA = myInput.nextDouble();
        System.out.println("The B number: ");
        double numB = myInput.nextDouble();
        System.out.println("The C number: ");
        double numC = myInput.nextDouble();

        if (numA < numC && numB > numC) {
            System.out.printf("The number C: %f is between %f and %f", numC, numA, numB);
        } else {
            System.out.printf("The number C: %f is not between %f and %f", numC, numA, numB);
        }
    }
}
