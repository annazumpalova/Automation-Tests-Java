public class Vehicle {
    String model;
    int horsePower;
    double fuel;
    double defaultFuelConsumption;
    double fuelConsumption;

    public Vehicle() {
    }

    public Vehicle(String model, int hoursePower, double fuel) {
        this.model = model;
        this.horsePower = hoursePower;
        this.fuel = fuel;
        this.defaultFuelConsumption = 1.25;
    }

    public void Drive(double kilometre) {
        fuelConsumption = defaultFuelConsumption * (kilometre / 100);
        this.fuel = fuel - fuelConsumption;
        System.out.println("Up-to-date fuel after consumption: " + fuel);
        System.out.println("Drive like a " + this.getClass().getSimpleName());
    }
}
