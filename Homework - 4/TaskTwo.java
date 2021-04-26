import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("First number: ");
        int firstNumber = sc.nextInt();
        System.out.print("Second number: ");
        int secondNumber = sc.nextInt();

        int maxNumber = getMaxTwo(firstNumber, secondNumber);
        System.out.printf("Max: %d\n", maxNumber);


        System.out.print("First number: ");
        int numOne = sc.nextInt();
        System.out.print("Second number: ");
        int numTwo = sc.nextInt();
        System.out.print("Third number: ");
        int numThree = sc.nextInt();

        int maxNumber2 = getMaxThree(numOne, numTwo, numThree);
        System.out.printf("Max: %d", maxNumber2);


    }

    public static int getMaxTwo(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }

    public static int getMaxThree(int num1, int num2, int num3) {
        if (num1 > num2 && num1 > num3) {
            return num1;
        } else if (num2 > num1 && num2 > num3) {
            return num2;
        } else {
            return num3;
        }
    }
}
