package lab3.main;

import java.io.*;
import java.util.ArrayList;

abstract class Shape implements Drawable, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
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

    public static void writeArrayListToFile(ArrayList<Shape> shapes, String filename) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(shapes);
        objectOutputStream.close();
    }

    public static ArrayList<Shape> readArrayListFromFile(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Shape> shapesFromFile = (ArrayList<Shape>) objectInputStream.readObject();
        objectInputStream.close();
        return shapesFromFile;
    }

    @Override
    public String toString() {
        return "Shape color: " + this.shapeColor;
    }
}