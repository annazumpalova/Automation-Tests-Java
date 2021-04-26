import java.util.Scanner;

public class TaskSeven {
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
        int position = biggerNumberIndex(arr);
        if (position == -1) {
            System.out.print("No element.");
        } else {
            System.out.printf("%d index", position);
        }
    }

    public static int biggerNumberIndex(int[] arr) {
        int index = 0;
        for (int k = 1; k <= arr.length - 2; k++) {
            if (arr[k - 1] < arr[k] && arr[k] > arr[k + 1]) {
                index = k;
            }
        }
        if (index > 0) {
            return index;
        } else {
            return -1;
        }
    }
}
