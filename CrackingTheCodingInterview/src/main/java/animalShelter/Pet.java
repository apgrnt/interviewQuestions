package animalShelter;

public class Pet {
    String name;

    public Pet(String name) {
	this.setName(name);
    }

    public Pet() {
	this.setName("Unknown Name");
    }

    public Object getName() {
	return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

}
