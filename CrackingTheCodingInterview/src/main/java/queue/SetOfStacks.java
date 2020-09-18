package queue;

import java.util.Stack;

public class SetOfStacks<E> {
    
    private Stack<Stack<E>> stackOfStacks = new Stack<Stack<E>>();


    public void push(E object) {
	if(stackOfStacks.isEmpty()){
	    Stack<E> stack = new Stack<E>();
	    stack.push(object);
	    stackOfStacks.push(stack);
	} else {
	  Stack<E> stack = stackOfStacks.peek();
	  if(stack.size() >= 5){
	      Stack<E> newStack = new Stack<E>();
	      newStack.push(object);
	      stackOfStacks.push(newStack);
	  } else {
	      stack.push(object);
	  }
	}
    }

    public E pop() {
	if (!stackOfStacks.isEmpty()) {
	    Stack<E> stack = stackOfStacks.pop();
	    E obj = null;
	    if (!stack.isEmpty()) {
		obj = stack.pop();
	    }
	    if(!stack.isEmpty()){
		stackOfStacks.push(stack);
	    }
	    return obj;
	}
	return null;
    }

    public int getNumberOfStacks() {
	return stackOfStacks.size();
    }

    public int getNumberOfPlates() {
	int numberOfStacks = getNumberOfStacks();
	int numberOfPlates = 0;
	if(numberOfStacks > 0){
	    numberOfPlates = (numberOfStacks-1)*5;
	    numberOfPlates += stackOfStacks.peek().size();
	}
	return numberOfPlates;
    }

}
