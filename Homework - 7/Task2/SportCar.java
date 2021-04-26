public class SportCar extends Car {

    public SportCar() {
    }

    public SportCar(String model, int hoursePower, double fuel) {
        super(model, hoursePower, fuel);
        defaultFuelConsumption = 10;
    }

    @Override
    public void Drive(double kilometre) {
        super.Drive(kilometre);
    }
}
