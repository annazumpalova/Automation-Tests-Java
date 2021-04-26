public class FamilyCar extends Car {

    public FamilyCar() {
    }

    public FamilyCar(String model, int hoursePower, double fuel) {
        super(model, hoursePower, fuel);
    }

    @Override
    public void Drive(double kilometre) {
        super.Drive(kilometre);
    }
}
