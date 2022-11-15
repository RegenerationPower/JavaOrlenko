package lab3.main;

public class Circle extends Shape {
    private final double radius;

    protected Circle(String circleColor, double radius) {
        super(circleColor);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Draw circle:\n" + this);
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "\nCircle area: " + String.format("%.3f", calcArea()) + "\n" + super.toString() +
                "\nRadius: " + String.format("%.3f", radius);
    }
}