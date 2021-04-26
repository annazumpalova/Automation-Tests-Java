import java.util.Scanner;

public class TaskTen {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Number: ");
        int num = myInput.nextInt();
        int sum = 0;

        for (int i = 1; i <= num; i++) {
            sum += i;
        }

        System.out.printf("The sum is : %d", sum);
    }
}
