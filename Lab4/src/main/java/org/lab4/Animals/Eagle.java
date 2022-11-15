package org.lab4.Animals;

public class Eagle extends Bird {
    public Eagle(String name, Integer cost, double weight) {
        super(name, cost, weight);
    }

    @Override
    public String toString(){
        return "Eagle: name: " + name + "; cost: " + cost + "$; weight: " + weight + "kg";
    }

}