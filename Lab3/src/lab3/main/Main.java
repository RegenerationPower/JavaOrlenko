/*
ІО-04 Возниця Дмитро
3.1. Напишіть консольний додаток, використовуючи архітектурний шаблон MVC, який:
•	описує інтерфейс Drawable з методом побудови фігури draw();
•	описує абстрактний клас Shape, який реалізує інтерфейс Drawable і містить поле shapeColor типу String для кольору фігури і конструктор для його ініціалізації, абстрактний метод обчислення площі фігури calcArea() і перевизначений метод toString();
•	описує класи Rectangle, Triangle, Circle, які успадковуються від класу Shape і реалізують метод calcArea (), а також перевизначають  метод toString ();
•	створює набір даних типу Shape (масив розмірністю не менш 10 елементів);
•	обробляє масив:
-	відображає набір даних;
-	обчислює сумарну площу всіх фігур набору даних;
-	обчислює сумарну площу фігур заданого виду;
-	впорядковує набір даних щодо збільшення площі фігур, використовуючи об'єкт інтерфейсу Comparator;
-	впорядковує набір даних за кольором фігур, використовуючи об'єкт інтерфейсу Comparator.
Значення для ініціалізації об'єктів вибираються з заздалегідь підготовлених даних (обраних випадковим чином або по порядку проходження).

 */
package lab3.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name to scan from or leave line empty: ");
        String inputFilename = scanner.nextLine();
        ArrayList<Shape> shapes;
        if (inputFilename.equals("")) {
            shapes = createShapes();
        } else {
            try {
                shapes = Shape.readArrayListFromFile(inputFilename);
            } catch (Exception exception) {
                exception.printStackTrace();
                return;
            }
        }
        ShapesModel model = new ShapesModel(shapes);
        ShapesView view = new ShapesView();
        ShapesController controller = new ShapesController(model, view);
        controller.printSumOfAllAreas();
        System.out.println("\n\tEnter shape to calculate its area sum (circle, triangle, rectangle): ");
        String shapesCalculateArea = scanner.nextLine();
        controller.printSumOfShapesAreas(shapesCalculateArea);
        System.out.println("\n\tShapes:");
        controller.printShapes();
        System.out.println("\n\tSorted by area:");
        controller.sortByArea();
        controller.printShapes();
        System.out.println("\n\tSorted by color:");
        controller.sortByColor();
        controller.printShapes();
        System.out.println("\n\tEnter an element to draw:");
        String shapeIndex = scanner.nextLine();
        System.out.println("\n\tDraw " + shapeIndex + " element:");
        controller.draw(shapeIndex);
        System.out.print("Enter file name to save to or leave line empty: ");
        String outputFilename = scanner.nextLine();
        if (!outputFilename.equals("")) {
            try {
                Shape.writeArrayListToFile(shapes, outputFilename);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private static ArrayList<Shape> createShapes() {
        return new ArrayList<>(Arrays.asList(
               new Circle("white", 2)));
/*                new Circle("black", 3),
                new Circle("yellow", 4),
                new Circle("green", 5),
                new Triangle("red", 2, 3, 4),
                new Triangle("blue", 5, 6, 7),
                new Triangle("violet", 8, 9, 10),
                new Triangle("orange", 11, 12, 13),
                new Rectangle("cyan", 2, 3),
                new Rectangle("pink", 4, 5),
                new Rectangle("brown", 6, 7),
                new Rectangle("gray", 8, 9)));*/
    }
}