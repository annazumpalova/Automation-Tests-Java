package Task1;

public class TaskOne {
    public static void main(String[] args) {
        Box test1 = new Box(5.4, 7.5, 5.4);
        System.out.println("Lateral surface area: " + test1.calculateLateralSurfaceArea());
        System.out.println("Surface area: " + test1.calculateSurfaceArea());
        System.out.println("Volume: " + test1.calculateVolume());
    }
}
