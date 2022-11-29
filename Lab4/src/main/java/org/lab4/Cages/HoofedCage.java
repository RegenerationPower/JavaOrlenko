package org.lab4.Cages;

import org.lab4.Animals.Animal;
import org.lab4.Animals.Hoofed;
import org.lab4.Animals.Mammal;

public class HoofedCage extends MammalCage<Mammal> {
    public HoofedCage(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    public boolean checkAnimal(Animal animal) {
        return animal instanceof Hoofed;
    }

}
