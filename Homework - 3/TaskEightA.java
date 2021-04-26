import java.util.Arrays;
import java.util.Scanner;

public class TaskEightA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Rows: ");
        int row = sc.nextInt();
        System.out.print("Columns: ");
        int column = sc.nextInt();
        int[][] matrix = new int[row][column];

        // Subtask A
        for (int i = 0; i < row; i++) {
            int num = i + 1;
            matrix[i][0] = i + 1;
            for (int j = 1; j < column; j++) {
                num = num + column;
                matrix[i][j] = num;
            }
        }
        for (int k = 0; k < matrix.length; k++) {
            for (int p = 0; p < matrix[k].length; p++) {
                System.out.print(matrix[k][p] + " ");
            }
            System.out.println();
        }
    }
}
