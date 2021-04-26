package Task4;

public class Circle extends Shape {
    double radius;

    public Circle(double rad){
        this.setRadius(rad);
    }

    public double getRadius() {
        return radius;
    }

    private void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        }
    }

    @Override
    public void calculateArea() {
        this.area = Math.PI * this.getRadius() * this.getRadius();
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = Math.PI * 2 * this.getRadius();
    }
}
