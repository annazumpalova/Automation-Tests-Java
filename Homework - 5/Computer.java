public class Computer {
    int year;
    double price;
    boolean isNotebook;
    double hardDiskMemory;
    double freeMemory;
    String operationSystem;

    void changeOperatingSystem(String newOperatingSystem) {
        operationSystem = newOperatingSystem;
    }

    void useMemory(double memory) {
        if (memory > freeMemory) {
            System.out.print("Not enough free memoty!");
        } else {
            freeMemory = freeMemory - memory;
        }
    }
}
