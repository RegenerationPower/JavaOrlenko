package lab3.main;

public class Rectangle extends Shape {
    private final double height, width;

    protected Rectangle(String rectangleColor, double height, double width) {
        super(rectangleColor);
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("Draw rectangle:\n" + this);
    }

    @Override
    public double calcArea() {
        return height * width;
    }

    @Override
    public String toString() {
        return "\nRectangle area: " + String.format("%.3f", calcArea()) + "\n" + super.toString() + "\nHeight: " +
                String.format("%.3f", height) + "\nWidth: " + String.format("%.3f", width);
    }
}