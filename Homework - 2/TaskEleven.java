import java.util.Scanner;

public class TaskEleven {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Number: ");
        int num = myInput.nextInt();

        for (int i = 1; i <= num; i++) {
            System.out.printf("%d , ", 3*i);
        }
    }
}
