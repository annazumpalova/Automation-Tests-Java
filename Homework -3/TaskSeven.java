import java.util.Scanner;

public class TaskSeven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[1];
        boolean stopper = true;
        int index = 0;

        while (stopper) {
            System.out.printf("Enter number: ");
            int userInput = sc.nextInt();
            if (userInput == -1) {
                stopper = false;
            } else {
                arr[index] = userInput;
                index++;
                if (arr.length == index) {
                    int[] temp = new int[arr.length + 1];
                    for (int k = 0; k < arr.length; k++) {
                        temp[k] = arr[k];
                    }
                    arr = temp;
                }
            }
        }

        for (int j = 0; j < arr.length - 1; j++) {
            System.out.print(" " + arr[j] + " ");
        }
    }
}
