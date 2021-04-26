package Task4;

public class Rectangle extends Shape {

    double height;
    double width;

    public Rectangle(double recHeight, double recWidth){
        setHeight(recHeight);
        setWidth(recWidth);
    }

    private void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        }
    }

    private void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        }
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = 2 * (this.getHeight() + this.getWidth());
    }

    @Override
    public void calculateArea() {
        this.area = this.getHeight() * this.getWidth();
    }
}
