import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter length of the array");
        int arrLength = sc.nextInt();

        int[] firstArr = new int[arrLength];
        int[] secondArr = new int[arrLength];
        boolean equal = true;

        System.out.println("Please enter array 1 elements: ");
        for (int i = 0; i <= arrLength - 1; i++) {
            int userInput = sc.nextInt();
            firstArr[i] = userInput;
        }
        System.out.println("Please enter array 2 elements: ");
        for (int j = 0; j <= arrLength - 1; j++) {
            int userInput = sc.nextInt();
            secondArr[j] = userInput;
        }
        for (int k = 0; k <= arrLength - 1; k++) {
            if (firstArr[k] != secondArr[k]) {
                equal = false;
                break;
            }
        }
        if (equal){
            System.out.println("They are equal!");
        } else {
            System.out.println("They are not equal!");
        }
    }
}
