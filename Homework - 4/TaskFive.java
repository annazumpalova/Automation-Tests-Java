import java.util.Scanner;

public class TaskFive {
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
        int element = sc.nextInt();
        elementNeighbours(arr, element);
    }

    public static void elementNeighbours(int[] arr, int number) {
        int position = 0;
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] == number) {
                position = k;
            }
        }
        if (arr[position - 1] < number && number > arr[position + 1]) {
            System.out.printf("The number %d is bigger than %d and %d", number, arr[position - 1], arr[position + 1]);
        } else if (arr[position - 1] > number && number < arr[position + 1]) {
            System.out.printf("The number %d is smaller than %d and %d", number, arr[position - 1], arr[position + 1]);
        } else if (arr[position - 1] < number && number < arr[position + 1]) {
            System.out.printf("The number %d is bigger than %d but smaller than %d", number, arr[position - 1], arr[position + 1]);
        } else if (arr[position - 1] > number && number > arr[position + 1]){
            System.out.printf("The number %d is smaller than %d but bigger than %d", number, arr[position - 1], arr[position + 1]);
        }
    }
}
