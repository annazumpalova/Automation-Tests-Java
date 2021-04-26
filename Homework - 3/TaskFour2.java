import java.util.Scanner;

public class TaskFour2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter length of the array");
        int arrLength = sc.nextInt();

        int[] arr = new int[arrLength];

        System.out.println("Please enter array elements: ");
        for (int i = 0; i <= arrLength - 1; i++) {
            int userInput = sc.nextInt();
            arr[i] = userInput;
        }
        for (int k = 0; k < arrLength / 2; k++) {
            int initialNumber = arr[k];
            arr[k] = arr[arrLength - 1 - k];
            arr[arrLength - 1 - k] = initialNumber;
        }
        for (int j = 0; j <= arrLength - 1; j++) {
            System.out.print(" " + arr[j] + " ");
        }
    }
}