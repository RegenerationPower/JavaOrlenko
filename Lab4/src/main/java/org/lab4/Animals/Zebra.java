package org.lab4.Animals;

public class Zebra extends Hoofed {
    public Zebra(String name, Integer cost, double weight) {
        super(name, cost, weight);
    }

    @Override
    public String toString(){
        return "Zebra: name: " + name + "; cost: " + cost + "$; weight: " + weight + "kg";
    }

}
