package org.lab4.Cages;

import org.lab4.Animals.Animal;
import org.lab4.Animals.Hoofed;

public class HoofedCage extends MammalCage {
    public HoofedCage(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    public boolean checkAnimal(Animal animal) {
        return animal instanceof Hoofed;
    }

}
