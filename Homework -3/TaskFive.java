import java.util.Scanner;

public class TaskFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter length of the array");
        int arrLength = sc.nextInt();

        int[] firstArr = new int[arrLength];
        int[] secondArr = new int[arrLength + 1];

        System.out.println("Please enter array elements: ");
        for (int i = 0; i <= arrLength - 1; i++) {
            int userInput = sc.nextInt();
            firstArr[i] = userInput;
        }

        secondArr[0] = firstArr[0];

        for (int k = 1; k < secondArr.length; k++) {
            secondArr[k] = firstArr[k - 1] * k;
        }

        for (int j = 0; j <= secondArr.length - 1; j++) {
            System.out.print(" " + secondArr[j] + " ");
        }
    }
}
