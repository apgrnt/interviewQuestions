package chapt3;

import utils.Plate;
import org.junit.jupiter.api.Test;
import queue.SetOfStacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/*
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. 
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold. 
 * 
 * Implement a data structure "SetOfStacks" that mimics this. 
 * "SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity.
 * "SetOfStacks.push()" and "SetOfStacks.pop()" shold behave identically to a single stack
 * (that is, pop() should return the same values as it would if there were just a single stack).
 * 
 * Stacks can only be 5 high
 * 
 * FOLLOW UP
 * 
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack
 */
public class ThreePointThreeTest {

    
    @Test
    public void createSetOfStacksObject(){
	SetOfStacks<Plate> setOfStacks = new SetOfStacks<Plate>();
	assertNotNull(setOfStacks);
    }
    
    @Test
    public void testPushAndPop(){
	SetOfStacks<Plate> setOfStacks = new SetOfStacks<Plate>();
	setOfStacks.push(new Plate(0));
	Plate plate = setOfStacks.pop();
	assertNotNull(plate);
	assertEquals(0, plate.getPlateNumber());
    }

    @Test
    public void testPushAndPopTwoPlates(){
	SetOfStacks<Plate> setOfStacks = new SetOfStacks<Plate>();
	setOfStacks.push(new Plate(0));
	setOfStacks.push(new Plate(1));
	assertEquals(1, setOfStacks.pop().getPlateNumber());
	assertEquals(0, setOfStacks.pop().getPlateNumber());
    }
    
    @Test
    public void testGetNumberOfStacks(){
	SetOfStacks<Plate> setOfStacks = new SetOfStacks<Plate>();
	assertEquals(0, setOfStacks.getNumberOfStacks());
	for(int i = 0; i < 5; i++){
	    setOfStacks.push(new Plate(i));
	}
	assertEquals(1, setOfStacks.getNumberOfStacks());
	setOfStacks.push(new Plate(5));
	assertEquals(2, setOfStacks.getNumberOfStacks());
	
    }
    
    @Test
    public void testMakingMultipleStackAndReducing(){
	SetOfStacks<Plate> setOfStacks = new SetOfStacks<Plate>();
	assertEquals(0, setOfStacks.getNumberOfStacks());
	for(int i = 0; i<15; i++){
	    setOfStacks.push(new Plate(i));
	}
	assertEquals(3, setOfStacks.getNumberOfStacks());
	Plate plate14 = setOfStacks.pop();
	assertNotNull(plate14);
	assertEquals(14, plate14.getPlateNumber());
	assertNotNull(setOfStacks.pop());
	assertNotNull(setOfStacks.pop());
	assertNotNull(setOfStacks.pop());
	assertNotNull(setOfStacks.pop());
	Plate plate9 = setOfStacks.pop();
	assertNotNull(plate9);
	assertEquals(9, plate9.getPlateNumber());
	assertEquals(2, setOfStacks.getNumberOfStacks());
    }
    
    @Test
    public void testGetNumberOfPlatesInAllStacks(){
	SetOfStacks<Plate> setOfStacks = new SetOfStacks<Plate>();
	assertEquals(0, setOfStacks.getNumberOfPlates());
	setOfStacks.push(new Plate(0));
	assertEquals(1, setOfStacks.getNumberOfPlates());
	for(int i = 1; i<15; i++){
	    setOfStacks.push(new Plate(i));
	}
	assertEquals(15, setOfStacks.getNumberOfPlates());
	for(int i = 14; i>=0; i--){
	    setOfStacks.pop();
	}
	assertEquals(0, setOfStacks.getNumberOfStacks());
	assertEquals(0, setOfStacks.getNumberOfPlates());
    }
}
