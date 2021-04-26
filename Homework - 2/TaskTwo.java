import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        System.out.println("The first number: ");
        double numA = myInput.nextDouble();
        System.out.println("The second number: ");
        double numB = myInput.nextDouble();

        if (numA > numB){
            System.out.printf("%f , %f", numB, numA);
        } else if(numA < numB){
            System.out.printf("%f , %f", numA, numB);
        } else if(numA == numB){
            System.out.printf("%f = %f", numB, numA);
        }
    }
}
