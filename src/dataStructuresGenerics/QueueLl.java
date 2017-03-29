package dataStructuresGenerics;

public class QueueLl<T extends Comparable<T>> {

	/*
	 * Antonin Jousson
	 * 
	 * Linked list based Queue data structure.
	 */

	private LinkedList<T> data;

	// constructor that calls the Linked list constructor
	public QueueLl() {
		data = new LinkedList<T>();
	}

	// Push method that calls the Linked list addFirst method.
	// Time complexity: O(1)
	public void push(T o) {
		this.data.addFirst(o);
	}

	// Pop method that calls the Linked list removeLast method.
	// Time complexity: O(n)
	public T pop() {
		T last = data.getLast();
		this.data.removeLast();
		return last;
	}

	// Top method returns the first element of the Queue (which is the last
	// element of the Linked list)
	public T top() {
		T top = data.getLast();
		return top;
	}

	// return the size of the Queue (i.e the size of the Linked list)
	public int size() {
		return data.size();
	}

	// Check if the Queue is empty
	public boolean empty() {
		return data.isEmpty();
	}

	// method that overloads the system.out.println method to be able to
	// directly print a Queue via System.out.println(myQueue)
	public String toString() {
		return this.data.toString();
	}
}
