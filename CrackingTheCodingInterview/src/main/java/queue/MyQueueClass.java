package queue;

import java.util.Queue;
import java.util.Stack;

public class MyQueueClass {
	private static final Exception StackFullException = null;
	private int queueSize = 0;
	private final int STACK_LIMIT = 5;
	private final Stack<Node> stack1 = new Stack();
	private final Stack<Node> stack2 = new Stack();

	public void push(Node node) throws Exception {
		if (stack1.size() == 5) {
			if (stack2.size() == 5) {
					throw StackFullException;
			} else {
				stack2.push(node);
				queueSize++;
			}
		} else {
			stack1.push(node);
			queueSize++;
		}
	}

	public int size() {
		return queueSize;
	}

	public Node pop() {
		if (stack2.size() == 0) {
			queueSize--;
			return stack1.pop();
		}
		return stack2.pop();
	}

}
