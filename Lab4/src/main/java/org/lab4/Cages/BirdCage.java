package org.lab4.Cages;

import org.lab4.Animals.Animal;
import org.lab4.Animals.Bird;

public class BirdCage extends Cage<Bird> {
    public BirdCage(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    public boolean checkAnimal(Animal animal){
        return animal instanceof Bird;
    }

}