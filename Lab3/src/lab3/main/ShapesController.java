package lab3.main;


public class ShapesController {
    private final ShapesModel model;
    private final ShapesView view;

    protected ShapesController(ShapesModel model, ShapesView view) {
        this.model = model;
        this.view = view;
    }

    protected void printSumOfAllAreas() {
        view.printSumOfAllAreas(model.getSumOfAllAreas());
    }


    protected void printSumOfShapesAreas(String shapeTypeToCalculateArea) {
        double sumOfShapesAreas = model.getSumOfShapesAreas(shapeTypeToCalculateArea);
        if (sumOfShapesAreas != -1) {
            view.printSumOfCustomAreas(model.getSumOfShapesAreas(shapeTypeToCalculateArea), shapeTypeToCalculateArea);
        } else {
            view.printError(shapeTypeToCalculateArea + " Incorrect input");
        }
    }

    protected void sortByArea() {
        model.sortByArea();
    }

    protected void sortByColor() {
        model.sortByColor();
    }

    protected void printShapes() {
        view.printShapes(model.getShapes());
    }

    public void draw(String index) {
        try {
            Integer.parseInt(index);
            model.draw(Integer.parseInt(index));
        } catch (NumberFormatException e) {
            view.printError(index + " Incorrect input");
        }
    }
}
