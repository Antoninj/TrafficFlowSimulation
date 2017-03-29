package dataStructuresGenerics;

public class StackLl<T extends Comparable<T>> {

	/*
	 * Antonin Jousson
	 * 
	 * Linked list based Stack data structure.
	 */

	private LinkedList<T> data;

	// constructor that calls the Linked list constructor
	public StackLl() {
		data = new LinkedList<T>();
	}

	// Push method that calls the Linked list addFirst method.
	// Time complexity: O(1)
	public void push(T o) {
		this.data.addFirst(o);

	}

	// Pop method that calls the Linked list removeFirst method.
	// Time complexity: O(1)
	public T pop() {
		T first = data.getFirst();
		this.data.removeFirst();
		return first;
	}

	// Top method returns the first element of the Stack (which is the first
	// element of the Linked list)
	public T top() {
		T top = data.getFirst();
		return top;
	}

	public T bottom() {
		T bottom = data.getLast();
		return bottom;
	}

	// return the size of the Stack (i.e the size of the Linked list)
	public int size() {
		return this.data.size();
	}

	// Check if the Stack is empty
	public boolean empty() {
		return this.data.isEmpty();
	}

	// method that overloads the system.out.println method to be able to
	// directly print a Stack via System.out.println(myStack)
	public String toString() {
		return this.data.toString();
	}
}
