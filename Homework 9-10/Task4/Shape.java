package Task4;

public abstract class Shape {
    double perimeter;
    double area;

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    private void setArea(double area) {
        if (area > 0) {
            this.area = area;
        }
    }

    private void setPerimeter(double perimeter) {
        if (perimeter > 0) {
            this.perimeter = perimeter;
        }
    }

    public abstract void calculatePerimeter();

    public abstract void calculateArea();
}
