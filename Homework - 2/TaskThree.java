import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        System.out.println("The first number: ");
        double numA = myInput.nextDouble();
        System.out.println("The second number: ");
        double numB = myInput.nextDouble();
        System.out.println("The third number: ");
        double numC = myInput.nextDouble();

        if (numA < numC && numA < numB && numB < numC){
            System.out.printf("%f , %f , %f", numA, numB, numC);
        } else if (numA < numC && numA < numB && numB > numC){
            System.out.printf("%f , %f , %f", numA, numC, numB);
        } else if (numB < numC && numB < numA && numA < numC){
            System.out.printf("%f , %f , %f", numB, numA, numC);
        } else if (numB < numC && numB < numA && numA > numC){
            System.out.printf("%f , %f , %f", numB, numC, numA);
        } else if (numC < numB && numC < numA && numA > numB){
            System.out.printf("%f , %f , %f", numC, numB, numA);
        } else if (numC < numB && numC < numA && numA < numB){
            System.out.printf("%f , %f , %f", numC, numA, numB);
        }
    }
}
