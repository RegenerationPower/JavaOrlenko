package lab3.main;

import java.util.ArrayList;

public class ShapesView {
    void printSumOfAllAreas(double sumOfAllAreas) {
        System.out.println("Sum of all areas is " + String.format("%.3f", sumOfAllAreas));
    }

    void printSumOfCustomAreas(double sumOfCustomAreas, String shapeType) {
        System.out.println("Sum of all " + shapeType + " areas is " + String.format("%.3f", sumOfCustomAreas));
    }

    void printShapes(ArrayList<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    void printError(String errorMessage) {
        System.out.println("ERROR - " + errorMessage);
    }
}