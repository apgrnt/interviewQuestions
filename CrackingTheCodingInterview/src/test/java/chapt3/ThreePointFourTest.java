package chapt3;

import org.junit.jupiter.api.Test;
import queue.MyQueueClass;
import queue.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;


/*
 * Queue via Stacks: 
 * Implement a MyQueueClass which implements a queue using two stacks.
 * hints #97, #113
 * 
 * Stack is first on last off.
 * queue is first in first out.
 */
public class ThreePointFourTest {
    
    @Test
    public void testPush() throws Exception{
	MyQueueClass queue = new MyQueueClass();
	queue.push(new Node(1));
	assertEquals(queue.size(), 1);
    }
    
    @Test
    public void testPop() throws Exception {
	MyQueueClass queue = new MyQueueClass();
	queue.push(new Node(1));
	Node node = queue.pop();
	assertEquals(1, node.getValue());
	assertEquals(queue.size(), 0);
    }
    
    @Test
    public void testPopInOrder() throws Exception {
	MyQueueClass queue = new MyQueueClass();
	for(int x = 0; x < 5; x++){
	    queue.push(new Node(x));
	}
	assertEquals(5, queue.size());
	for(int x = 4; x == 0 ; x--){
	    Node popped = queue.pop();
	    assertEquals(x, popped);
	}
    }
    
    @Test
    public void testSecondStack() throws Exception{
	MyQueueClass queue = new MyQueueClass();
	for(int x = 0; x < 6; x++){
	    queue.push(new Node(x+1));
	}
	Node popped = queue.pop();
	assertEquals(6, popped.getValue());
	
    }
}
