package org.lab4.Animals;

public class Giraffe extends Hoofed {
    public Giraffe(String name, Integer cost, double weight) {
        super(name, cost, weight);
    }

    @Override
    public String toString(){
        return "Giraffe: name: " + name + "; cost: " + cost + "$; weight: " + weight + "kg";
    }

}
