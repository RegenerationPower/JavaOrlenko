package org.lab4.Animals;

public abstract class Mammal extends Animal {
    Mammal(String name, Integer cost, double weight) {
        super(name, cost, weight);
    }

    @Override
    public String toString(){
        return "Mammal: name: " + name + "; cost: " + cost + "$; weight: " + weight + "kg";
    }

}
