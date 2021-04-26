package Task1And2;

import java.util.Scanner;

public class StartUp {
    public Person[] array = new Person[1];

    private int index = 0;
    Scanner myInput = new Scanner(System.in);

    public void createPerson(int arrLength) {
        System.out.println("Name: ");
        String personalName = myInput.next();
        System.out.println("Age: ");
        int personalAge = myInput.nextInt();
        System.out.println("Salary: ");
        double personalSalary = myInput.nextDouble();

        Person worker = new Person(personalName, personalAge, personalSalary);

        if (index == array.length) {
            Person[] temp = new Person[array.length + 1];
            for (int k = 0; k < array.length; k++) {
                temp[k] = array[k];
            }
            array = temp;
        }
        array[index] = worker;
        index++;
    }
}

