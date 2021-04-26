package Task4;

import java.awt.*;

public class Task4 {
    public static void main(String[] args) {
        Circle firstCirle = new Circle(3.5);
        Rectangle firstRectangle = new Rectangle(4.5, 8.5);

        firstCirle.calculateArea();
        firstCirle.calculatePerimeter();
        firstRectangle.calculateArea();
        firstRectangle.calculatePerimeter();

        System.out.println("Circle results: "+ firstCirle.area + " and "+ firstCirle.perimeter);
        System.out.println("Rectangle results: "+ firstRectangle.area + " and "+ firstRectangle.perimeter);
    }
}
