package org.lab4.Animals;

public class Lion extends Mammal {
    public Lion(String name, Integer cost, double weight) {
        super(name, cost, weight);
    }

    @Override
    public String toString(){
        return "Lion: name: " + name + "; cost: " + cost + "$; weight: " + weight + "kg";
    }

}
