import java.util.Scanner;

public class TaskSix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter length of the array");
        int arrLength = sc.nextInt();
        int startPosition = 0;
        int endPosition = 0;

        int[] arr = new int[arrLength];

        System.out.println("Please enter array elements: ");
        for (int i = 0; i <= arrLength - 1; i++) {
            int userInput = sc.nextInt();
            arr[i] = userInput;
        }

        for (int k = 0; k < arrLength - 1; k++){
            if (arr[k] == arr[k+1]){
                startPosition = k;
                for (int j = startPosition; j <= arrLength - 1; j++){
                    if (arr[j] == arr[j-1]){
                        endPosition = j;
                    }else{
                        k = endPosition;
                    }
                }
            }
        }
        for (int p = startPosition; p <= endPosition; p++) {
            System.out.print(" " + arr[p] + " ");
        }
    }
}
