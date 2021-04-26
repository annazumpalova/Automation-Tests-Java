import java.util.Scanner;

public class TaskFour {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        System.out.println("Money: ");
        double money = myInput.nextDouble();
        System.out.println("Am I healthy: ");
        boolean bn = myInput.nextBoolean();

        if (!bn) {
            System.out.println("I will not go out!");
            if (money > 0) {
                System.out.println("I will buy medical supplies.");
            } else if (money <= 0) {
                System.out.println("I will stay at home and drink hot tea.");
            }
        } else {
            System.out.println("I am healthy!");
            if (money < 10) {
                System.out.println("I will drink coffee.");
            } else {
                System.out.println("I will go to the cinema.");
            }
        }
    }
}

