package org.lab4.Animals;

public abstract class Hoofed extends Mammal {
    Hoofed(String name, Integer cost, double weight) {
        super(name, cost, weight);
    }

    @Override
    public String toString(){
        return "Hoofed: name: " + name + "; cost: " + cost + "$; weight: " + weight + "kg";
    }

}
