import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter length of the array");
        int arrLength = sc.nextInt();
        int maxNumber = Integer.MIN_VALUE;

        int[] arr = new int[arrLength];
        System.out.println("Please enter array elements: ");
        for (int i = 0; i <= arrLength - 1; i++) {
            int userInput = sc.nextInt();
            arr[i] = userInput;
            if (maxNumber < userInput) {
                maxNumber = userInput;
            }
        }
        System.out.printf("Max number: %d", maxNumber);
    }
}
