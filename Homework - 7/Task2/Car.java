public class Car extends Vehicle {

    public Car() {
    }

    public Car(String model, int hoursePower, double fuel) {
        super(model, hoursePower, fuel);
        if (this.getClass().getName().equals("Car")) {
            defaultFuelConsumption = 3;
        }
    }

    @Override
    public void Drive(double kilometre) {
        super.Drive(kilometre);
    }
}
