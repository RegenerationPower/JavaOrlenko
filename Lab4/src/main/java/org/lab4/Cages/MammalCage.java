package org.lab4.Cages;

import org.lab4.Animals.Mammal;

public abstract class MammalCage extends Cage<Mammal> {
    MammalCage(int maxCapacity) {
        super(maxCapacity);
    }

}