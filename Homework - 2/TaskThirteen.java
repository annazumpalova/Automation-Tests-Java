import java.util.Scanner;

public class TaskThirteen {
    public static void main(String[] args) {
        System.out.println("Number 1: ");
        Scanner myInput = new Scanner(System.in);
        int num1 = myInput.nextInt();
        System.out.println("Number 2: ");
        int num2 = myInput.nextInt();
        int powNum;
        int sum = 0;
        do {
            for (int i = num1; i <= num2; i++) {
                powNum = (int) Math.pow(i, 2);
                if (powNum % 3 == 0) {
                    System.out.println("Skip 3, ");
                } else {
                    sum += powNum;
                    System.out.printf("%d, ", powNum);
                }
            }
        } while (sum == 200);
    }
}
