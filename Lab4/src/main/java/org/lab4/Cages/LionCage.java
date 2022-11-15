package org.lab4.Cages;

import org.lab4.Animals.Animal;
import org.lab4.Animals.Lion;

public class LionCage extends MammalCage {
    public LionCage(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    boolean checkAnimal(Animal animal) {
        return animal instanceof Lion;
    }

}
