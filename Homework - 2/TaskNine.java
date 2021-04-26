import java.util.Scanner;

public class TaskNine {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("First number: ");
        int num1 = myInput.nextInt();
        System.out.println("Second number: ");
        int num2 = myInput.nextInt();

        if (num1 < num2) {
            for (int i = num1; i <= num2; i++) {
                System.out.printf("%d\n", i);
            }
        } else {
            for (int i = num2; i <= num1; i++) {
                System.out.printf("%d\n", i);
            }
        }

    }
}
