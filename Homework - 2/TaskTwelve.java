import java.util.Scanner;

public class TaskTwelve {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Number: ");
        int num = myInput.nextInt();
        int initialNumber = num - 1;

        for (int i = 1; i <= num; i++) {
            for (int k = 1; k <= num; k++) {
                System.out.printf("%d", initialNumber);
            }
            initialNumber = initialNumber + 2;
            System.out.println("\n");
        }
    }
}
