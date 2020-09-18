package chapt3;

import animalShelter.AnimalShelter;
import animalShelter.Cat;
import animalShelter.Dog;
import animalShelter.Pet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ThreePointSix {

    @Test
    public void createAnimalIntoShelter(){
	AnimalShelter<Pet> shelter;
	shelter = new AnimalShelter<Pet>();
	assertNotNull(shelter);
    }
    
    @Test
    public void putAPetInShelter(){
	AnimalShelter<Pet> shelter = new AnimalShelter<Pet>();
	shelter.add(new Cat());
	assertEquals(1, shelter.size());
    }
    
    @Test
    public void getOutOldestAnimal(){
	AnimalShelter<Pet> shelter = new AnimalShelter<Pet>();
	shelter.add(new Cat());
	shelter.add(new Dog());
	assertEquals(2, shelter.size());
	Pet oldestPet = shelter.poll();
	assertEquals(Cat.class, oldestPet.getClass());
    }
    
    @Test
    public void getOutOldestDog(){
	AnimalShelter<Pet> shelter = new AnimalShelter<Pet>();
	shelter.add(new Cat("Wiskers"));
	shelter.add(new Cat("Milche"));
	shelter.add(new Dog("Jess"));
	shelter.add(new Cat("Shitty"));
	shelter.add(new Dog("Tale"));
	assertEquals(5, shelter.size());
	Pet oldestDog = shelter.getDog();
	assertEquals(Dog.class, oldestDog.getClass());
	assertEquals("Jess", oldestDog.getName());
	assertEquals(4, shelter.size());
    }
    
    @Test
    public void getOutOldestCat(){
	AnimalShelter<Pet> shelter = new AnimalShelter<Pet>();
	shelter.add(new Dog("Jess"));
	shelter.add(new Dog("Tale"));
	shelter.add(new Cat("Wiskers"));
	shelter.add(new Cat("Milche"));
	shelter.add(new Cat("Shitty"));
	assertEquals(5, shelter.size());
	Pet oldestCat = shelter.getCat();
	assertEquals(Cat.class, oldestCat.getClass());
	assertEquals("Wiskers", oldestCat.getName());
	assertEquals(4, shelter.size());
    }
}
