package org.lab4.Cages;

import org.lab4.Animals.Animal;

import java.util.ArrayList;

public abstract class Cage<T extends Animal> {
    private final int maxCapacity;
    private final ArrayList<T> animals = new ArrayList<>();
    abstract boolean checkAnimal(Animal animal);

    Cage(int maxCapacity){
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity(){
        return maxCapacity;
    }

    public int getNumberOfAnimals(){
        return animals.size();
    }

    public void addAnimal(T animal) throws Exception {
        if (this.getNumberOfAnimals() == this.getMaxCapacity()) {
            throw new Exception("Cage is full");
        }
        else if(!checkAnimal(animal)){
            throw new Exception("Incorrect animal");
        }
        else {
            animals.add(animal);
        }
    }

    public void removeAnimal(T animal) throws Exception {
        boolean removed = animals.remove(animal);
        if(!removed) {
            throw new Exception("Animal not found");
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(T animal: animals){
            str.append(animal.toString()).append("\n");
        }
        return str.toString();
    }

}