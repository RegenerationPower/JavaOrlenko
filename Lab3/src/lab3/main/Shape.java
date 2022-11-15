package lab3.main;

abstract class Shape implements Drawable {
    private String shapeColor;

    protected Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    protected abstract double calcArea();

    protected String getShapeColor() {
        return shapeColor;
    }

    protected void setShapeColor(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    @Override
    public String toString() {
        return "Shape color: " + this.shapeColor;
    }
}