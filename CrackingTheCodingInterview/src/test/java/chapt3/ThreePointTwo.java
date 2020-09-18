package chapt3;

import java.util.ArrayList;


/*
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. 
 * Therefore, in real life, we would likely start a new stack when the previous stack
 * exceeds some threshold. Implement a data structure SetOfStacks that mimics this. 
 * SetOfStacks should be composed of several stacks and should create a new stack once
 * the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
 * (that is, pop() should return the same values as it would if there were just a single stack).
 * 	FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack. 
 */
public class ThreePointTwo {
    private final int STACK_SIZE = 5;
    private Stack currentStack = new Stack(null, STACK_SIZE);
    private int numberOfPlates = 0;
    private int numberOfStacks = 1;
    
    private class Stack {
	public Plate[] plates;
	private Stack previous;
	private Stack next;  //Maybe need to use if doing FOLLOW UP
	private int index = 0;
	private final int stackNumber;
	private int platesInStack = 0;
	
	public Stack(Stack previous, int stackSize){
	    if(previous != null){
		this.stackNumber = previous.stackNumber + 1;
		this.previous = previous;
	    }else {
		this.stackNumber = 0;
	    }
	    this.plates = new Plate[stackSize];
	}
	public void add(Plate plate){
	    plates[index] = plate;
	    numberOfPlates++;
	    platesInStack++;
	    index++;
	}
	
	public Plate pop(){
	    Plate plate = plates[index - 1];
	    plates[index] = null;
	    numberOfPlates--;
	    platesInStack--;
	    index--;
	    return plate;
	}
	
	public boolean isEmpty(){
	    if(getPlatesInStack() > 0){
		return false;
	    } else {
		return true;
	    }
	}
	
	public int getPlatesInStack(){
	    return platesInStack;
	}
    }
    
    public class Plate{
    
    }
    
    public void push(Plate plate){
	if(currentStack.getPlatesInStack() == STACK_SIZE){
	    currentStack = new Stack(currentStack, STACK_SIZE);
	    numberOfStacks++;
	}
	currentStack.add(plate);
    }
    
    public Plate pop(){
	Plate plate = currentStack.pop();
	if(currentStack.isEmpty()){
	    if(currentStack.previous != null){
		currentStack = currentStack.previous;
		numberOfStacks--;
	    } else{
		numberOfStacks = 0;
	    }
	}
	return plate;
	
    }

    public int getNumberOfPlates() {
	return numberOfPlates;
    }

    public int getNumberOfStacks() {
	return numberOfStacks;
    }
}
