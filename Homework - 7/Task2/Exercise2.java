public class Exercise2 {
    public static void main(String[] args) {

        Vehicle[] arrVehicle = new Vehicle[4];
        int kilometre = 20;

        arrVehicle[0] = new RaceMotorCycle("Model 1", 300, 80);
        arrVehicle[1] = new CrossMotorCycle("Model 2", 350, 60);
        arrVehicle[2] = new SportCar("Model 3", 450, 100);
        arrVehicle[3] = new FamilyCar("Model 4", 180, 120);

        for (int i = 0; i < arrVehicle.length; i++) {
            System.out.println("Model: " + arrVehicle[i].model);
            System.out.println("Hourse power: " + arrVehicle[i].horsePower);
            System.out.println("Fuel: " + arrVehicle[i].fuel);
            System.out.println("Default fuel consumption: " + arrVehicle[i].defaultFuelConsumption);
            arrVehicle[i].Drive(kilometre);
            kilometre = kilometre + 10;
            System.out.println("\n");
        }
    }
}
