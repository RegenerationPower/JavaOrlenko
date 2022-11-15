package org.lab4.Animals;

public abstract class Animal {
    String name;
    Integer cost;
    double weight;

    Animal(String name, Integer cost, double weight){
        this.name = name;
        this.cost = cost;
        this.weight = weight;
    }

}