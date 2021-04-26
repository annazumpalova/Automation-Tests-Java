package Task1;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height){
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    private void setLength(double length) {
        if (length > 0 && length != 0) {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if (width > 0 && width != 0) {
            this.width = width;
        }
    }

    private void setHeight(double height) {
        if (height > 0 && height != 0) {
            this.height = height;
        }
    }

    double calculateVolume(){
        double volume = this.getHeight() * this.getLength() * this.getWidth();
        return volume;
    }

    double calculateSurfaceArea(){
        double surfaceArea = 2*(this.getLength()*this.getWidth() + this.getLength()*this.getHeight() + this.getWidth()*this.getHeight());
        return surfaceArea;
    }

    double calculateLateralSurfaceArea(){
        double lateralSurfaceArea = 2*(this.getLength()*this.getHeight() + this.getWidth()*this.getHeight());
        return lateralSurfaceArea;
    }
}
