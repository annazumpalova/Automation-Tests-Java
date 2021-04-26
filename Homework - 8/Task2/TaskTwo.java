package Task1And2;

import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Number of workers: ");
        int numWorkers = myInput.nextInt();

        StartUp myStartUp = new StartUp();

        for (int i = 0; i < numWorkers; i++) {
            System.out.println("TaskTwo.Task1.Person " + (i+1));
            myStartUp.createPerson(numWorkers);
        }
        System.out.println("Percentage: ");
        double percentageSalary = myInput.nextDouble();

        for (int k = 0; k < numWorkers; k++) {
            double workerBonus = myStartUp.array[k].increaseSalary(percentageSalary);
            System.out.println(myStartUp.array[k].getName() + " receives " + workerBonus);
        }
    }
}
