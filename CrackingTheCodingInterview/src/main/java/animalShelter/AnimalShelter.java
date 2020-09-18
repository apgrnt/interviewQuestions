package animalShelter;

import java.util.LinkedList;
import java.util.Stack;

public class AnimalShelter<Pet> extends LinkedList<Pet> {

    public Pet getDog() {
	Stack<Pet> deque = new Stack<Pet>();
	while(!this.isEmpty()){
	    if(this.peek().getClass() != Dog.class){
		deque.push(this.pop());
	    } else {
		Pet dog = this.pop();
		while(!deque.isEmpty()){
		    this.addFirst(deque.pop());
		}
		return dog;
	    }
	}
	return null;
    }

    public Pet getCat() {
	Stack<Pet> deque = new Stack<Pet>();
	while(!this.isEmpty()){
	    if(this.peek().getClass() != Cat.class){
		deque.push(this.pop());
	    } else {
		Pet cat = this.pop();
		while(!deque.isEmpty()){
		    this.addFirst(deque.pop());
		}
		return cat;
	    }
	}
	return null;
    }
}
