import java.util.Scanner;

public class TaskFour1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter length of the array");
        int arrLength = sc.nextInt();

        int[] firstArr = new int[arrLength];
        int[] secondArr = new int[arrLength];

        System.out.println("Please enter array elements: ");
        for (int i = 0; i <= arrLength - 1; i++) {
            int userInput = sc.nextInt();
            firstArr[i] = userInput;
        }
        for (int k = 0; k <= arrLength - 1; k++) {
            secondArr[k] = firstArr[arrLength - 1 - k];
        }
        for (int j = 0; j < arrLength - 1; j++) {
            System.out.print(" " + secondArr[j] + " ");
        }

    }
}
