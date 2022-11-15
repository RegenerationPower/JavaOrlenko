package lab3.main;

public class Triangle extends Shape{
    private final double firstSide, secondSide, thirdSide;

    protected Triangle(String triangleColor, double firstSide, double secondSide, double thirdSide) {
        super(triangleColor);
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    @Override
    public void draw() {
        System.out.println("Draw triangle:\n" + this);
    }

    @Override
    public double calcArea() {
        double semiPerimeter = (firstSide + secondSide + thirdSide) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - firstSide) * (semiPerimeter - secondSide) * (semiPerimeter - thirdSide));
    }

    @Override
    public String toString() {
        return "\nTriangle area: " + String.format("%.3f", calcArea()) + "\n" +
                super.toString() + "\nSides: " + String.format("%.3f", firstSide) + ", " +
                String.format("%.3f", secondSide) + ", " + String.format("%.3f", thirdSide);
    }
}