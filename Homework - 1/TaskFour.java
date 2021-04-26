import java.util.Scanner;

public class TaskFour {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("The first number: ");
        int a1 = myInput.nextInt();
        System.out.println("The second number: ");
        int a2 = myInput.nextInt();
        System.out.println("The third number: ");
        int a3 = myInput.nextInt();

        int saveA1 = a1;
        int saveA2 = a2;
        int saveA3 = a3;

        a1 = saveA2;
        a2 = saveA3;
        a3 = saveA1;

        System.out.printf("First number: %d\n", a1);
        System.out.printf("Second number: %d\n", a2);
        System.out.printf("Second number: %d\n", a3);
    }
}
