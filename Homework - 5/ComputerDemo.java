public class ComputerDemo {
    public static void main(String[] args) {

        Computer laptop = new Computer();
        laptop.year = 2019;
        laptop.price = 1100;
        laptop.isNotebook = true;
        laptop.hardDiskMemory = 500;
        laptop.freeMemory = 400;
        laptop.operationSystem = "Linux";

        Computer compTable = new Computer();
        compTable.year = 2015;
        compTable.price = 1300;
        compTable.isNotebook = false;
        compTable.hardDiskMemory = 1000;
        compTable.freeMemory = 250;
        compTable.operationSystem = "Windows";

        laptop.useMemory(100);
        compTable.changeOperatingSystem("Mac OS");


        System.out.println("Laptop price is: " + laptop.price);
        System.out.println("Laptop year is: " + laptop.year);
        System.out.println("Is the laptop portable? Answer: " + laptop.isNotebook);
        System.out.println("Laptop hard disk memory is: " + laptop.hardDiskMemory);
        System.out.println("Laptop free space is: " + laptop.freeMemory);
        System.out.println("Laptop OS is: " + laptop.operationSystem);

        System.out.print("\n");

        System.out.println("Laptop price is: " + compTable.price);
        System.out.println("Laptop year is: " + compTable.year);
        System.out.println("Is the laptop portable? Answer: " + compTable.isNotebook);
        System.out.println("Laptop hard disk memory is: " + compTable.hardDiskMemory);
        System.out.println("Laptop free space is: " + compTable.freeMemory);
        System.out.println("Laptop OS is: " + compTable.operationSystem);


    }
}
