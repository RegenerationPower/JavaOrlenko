package org.lab4.Animals;

public abstract class Bird extends Animal {
    public Bird(String name, Integer cost, double weight) {
        super(name, cost, weight);
    }

    @Override
    public String toString(){
        return "Bird: name: " + name + "; cost: " + cost + "$; weight: " + weight + "kg";
    }

}