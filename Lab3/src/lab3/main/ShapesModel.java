package lab3.main;

import java.util.ArrayList;
import java.util.Comparator;

public class ShapesModel {
    private final ArrayList<Shape> shapes;

    ShapesModel(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    ArrayList<Shape> getShapes() {
        return shapes;
    }

    double getSumOfAllAreas() {
        double sumOfAllAreas = 0;
        for (Shape shape : shapes) {
            sumOfAllAreas += shape.calcArea();
        }
        return sumOfAllAreas;
    }

    double getSumOfShapesAreas(String shapeTypeToCalculateArea) {
        double sumOfShapesAreas = 0;
        for (Shape shape : shapes) {
            if (shapeTypeToCalculateArea.equalsIgnoreCase("rectangle")) {
                if (shape.getClass() == Rectangle.class) {
                    sumOfShapesAreas += shape.calcArea();
                }
            } else if (shapeTypeToCalculateArea.equalsIgnoreCase("triangle")) {
                if (shape.getClass() == Triangle.class) {
                    sumOfShapesAreas += shape.calcArea();
                }
            } else if (shapeTypeToCalculateArea.equalsIgnoreCase("circle")) {
                if (shape.getClass() == Circle.class) {
                    sumOfShapesAreas += shape.calcArea();
                }
            } else {
                return -1;
            }
        }
        return sumOfShapesAreas;
    }

    void sortByArea() {
        shapes.sort(Comparator.comparing(Shape::calcArea));
    }

    void sortByColor() {
        shapes.sort(Comparator.comparing(Shape::getShapeColor));
    }

    void draw(int index) {
        shapes.get(index).draw();
    }
}
