public class RaceMotorCycle extends Motorcycle {

    public RaceMotorCycle() {
    }

    public RaceMotorCycle(String model, int hoursePower, double fuel) {
        super(model, hoursePower, fuel);
        defaultFuelConsumption = 8;
    }

    @Override
    public void Drive(double kilometre) {
        super.Drive(kilometre);
    }
}
