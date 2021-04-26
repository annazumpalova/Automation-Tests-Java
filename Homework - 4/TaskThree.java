import java.util.Scanner;

public class TaskThree {
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
        System.out.println("Number chosen: ");
        int num = sc.nextInt();

        int countNum = meetNumber(arr, num);
        if (countNum == 0) {
            System.out.print("No matches.");
        } else {
            System.out.printf("The result: %d", countNum);
        }
    }

    public static int meetNumber(int[] arr, int num) {
        int count = 0;
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] == num) {
                count++;
            }
        }
        return count;
    }
}


