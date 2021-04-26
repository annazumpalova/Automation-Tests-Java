import java.util.Scanner;

public class TaskSix {
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
        double averageArr = arrAverage(arr);
        System.out.printf("The average of the array is %f", averageArr);

    }

    public static double arrAverage(int[] arr) {
        double sum = 0;
        for (int k = 0; k < arr.length; k++) {
            sum += arr[k];
        }
        return sum / arr.length;
    }
}
