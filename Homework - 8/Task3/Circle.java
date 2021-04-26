package Task3;

public class Circle {
    private double radius = 1;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    private void setRadius(double rad) {
        if (rad < 0 && rad != 0) {
            this.radius = rad;
        }
    }

    private void setColor(String col) {
        if (col != null && !col.isEmpty()) {
            this.color = col;
        }
    }

    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return Math.PI * this.getRadius() * this.getRadius();
    }

    public double getCircumference() {
        return 2 * Math.PI * this.getRadius();
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
