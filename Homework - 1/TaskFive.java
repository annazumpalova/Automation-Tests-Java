import java.util.Scanner;

public class TaskFive {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("The number: ");
        int num = myInput.nextInt();

        for (int i = 1; i <= 10; i++) {
            int newNumber = num * i;
            System.out.printf("%d: %d\n", i, newNumber);
        }
    }
}