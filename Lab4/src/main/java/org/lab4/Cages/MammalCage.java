package org.lab4.Cages;

import org.lab4.Animals.Mammal;

public abstract class MammalCage<L extends Mammal> extends Cage<Mammal> {
    MammalCage(int maxCapacity) {
        super(maxCapacity);
    }

}