package org.lab4;

import org.lab4.Animals.*;
import org.lab4.Cages.*;

public class Main {
    public static void main(String[] args) {
        BirdCage birdCage = new BirdCage(1);
        LionCage lionCage = new LionCage(2);
        HoofedCage hoofedCage = new HoofedCage(3);

        Eagle eagle = new Eagle("Eagle1", 500, 15.7);
        Eagle eagle2 = new Eagle("Eagle2", 550, 14.2);
        Lion lion = new Lion("Lion", 5367, 89.2);
        Zebra zebra = new Zebra("Zebra1", 2754, 63.6);
        Zebra zebra2 = new Zebra("Zebra2", 2623, 61.0);
        Giraffe giraffe = new Giraffe("Giraffe", 7543, 536.9);

        try {
            birdCage.addAnimal(eagle);
            birdCage.removeAnimal(eagle);
            birdCage.addAnimal(eagle2);
            lionCage.addAnimal(lion);
            //lionCage.addAnimal(giraffe);
            hoofedCage.addAnimal(zebra);
            hoofedCage.addAnimal(zebra2);

            Zoo zoo = new Zoo();
            zoo.addCage(birdCage);
            zoo.addCage(lionCage);
            zoo.addCage(hoofedCage);
            System.out.print(zoo);
            System.out.println("The number of animals: " + zoo.getCountOfAnimals());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}