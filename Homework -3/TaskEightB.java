import java.util.Arrays;
import java.util.Scanner;

public class TaskEightB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Rows: ");
        int row = sc.nextInt();
        System.out.print("Columns: ");
        int column = sc.nextInt();
        int[][] matrixB = new int[row][column];
        int numB = 1;

        for (int i = 0; i < column; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < row; j++) {
                    matrixB[j][i] = numB;
                    numB++;
                }
            } else {
                for (int j = row - 1; j >= 0; j--) {
                    matrixB[j][i] = numB;
                    numB++;
                }
            }
        }
        for (int k = 0; k < matrixB.length; k++) {
            for (int p = 0; p < matrixB[k].length; p++) {
                System.out.print(matrixB[k][p] + " ");
            }
            System.out.println();
        }
    }
}
