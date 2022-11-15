package org.lab4;

import org.lab4.Animals.Animal;
import org.lab4.Cages.Cage;

import java.util.ArrayList;

public final class Zoo {
    public ArrayList<Cage<? extends Animal>> cages = new ArrayList<>();

    public int getCountOfAnimals(){
        int sum = 0;
        for(Cage<? extends Animal> cage: cages){
            sum += cage.getNumberOfAnimals();
        }
        return sum;
    }

    public void addCage(Cage<? extends Animal> cage){
        cages.add(cage);
    }

    @Override
    public String toString(){
        StringBuilder strB = new StringBuilder();
        for(int i = 0; i < cages.size(); ++i){
            strB.append("Cage №").append(i + 1).append(":\n").append(cages.get(i).toString()).append("\n");
        }
        return strB.toString();
    }

}