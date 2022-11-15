package org.lab4.Cages;
import org.junit.function.ThrowingRunnable;
import org.lab4.Animals.*;
import org.lab4.Zoo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class CageTest {
    Zoo zoo;
    Eagle eagle;
    Lion lion;
    Zebra zebra;
    Giraffe giraffe;
    BirdCage birdCage;
    LionCage lionCage;
    HoofedCage hoofedCage;

    @Before
    public void init(){
        birdCage = new BirdCage(1);
        lionCage = new LionCage(2);
        hoofedCage = new HoofedCage(3);
        eagle = new Eagle("Eagle", 476, 17.2);
        lion = new Lion("Lion", 7893, 103.6);
        zebra = new Zebra("Zebra", 2462, 58.4);
        giraffe = new Giraffe("Giraffe", 8934, 698.3);
        zoo = new Zoo();
    }

    @Test
    public void addCages() throws Exception {
        lionCage.addAnimal(lion);
        hoofedCage.addAnimal(zebra);
        hoofedCage.addAnimal(giraffe);
        zoo.addCage(birdCage);
        zoo.addCage(lionCage);
        zoo.addCage(hoofedCage);
        assertEquals(3, zoo.getCountOfAnimals());
    }

    @Test
    public void addIncorrectAnimalShouldThrowException(){
        Exception exception = assertThrows(Exception.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                hoofedCage.addAnimal(lion);
            }
        });
        assertEquals("Incorrect animal", exception.getMessage());
    }

    @Test
    public void removeIncorrectAnimalShouldThrowException(){
        Exception exception = assertThrows(Exception.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                lionCage.removeAnimal(giraffe);
            }
        });
        assertEquals("Animal not found", exception.getMessage());
    }

    @Test
    public void fullCageShouldThrowException(){
        Exception exception = assertThrows(Exception.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                birdCage.addAnimal(eagle);
                birdCage.addAnimal(eagle);
            }
        });
        assertEquals("Cage is full", exception.getMessage());
    }

    @Test
    public void addAnimalToHoofedCage() throws Exception {
        hoofedCage.addAnimal(zebra);
        assertEquals(3, hoofedCage.getMaxCapacity());
        assertEquals(1, hoofedCage.getNumberOfAnimals());
    }

    @Test
    public void addAnimalToBirdCage() throws Exception {
        birdCage.addAnimal(eagle);
        assertEquals(1, birdCage.getMaxCapacity());
        assertEquals(1, birdCage.getNumberOfAnimals());
    }

    @Test
    public void addAnimalToLionCage() throws Exception {
        lionCage.addAnimal(lion);
        assertEquals(2, lionCage.getMaxCapacity());
        assertEquals(1, lionCage.getNumberOfAnimals());
    }

}
