package queue;

public class Node<T> {
	
	private final T value;
	
	public Node(T item){
		this.value = item;
	}

	public T getValue() {
		return value;
	}

}
