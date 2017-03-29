package dataStructuresGenerics;

public class Queue<T> {

	/*
	 * Antonin Jousson
	 * 
	 * Vector based Queue data structure.
	 */

	private CircularVector<T> data;

	// constructor that calls the Vector constructor
	public Queue(int capacity) {
		data = new CircularVector<T>(capacity);
	}

	// Push method that calls the vector addLast method, time complexity : O(1)
	public void push(T o) {
		this.data.addLast(o);
	}

	// Pop method that calls the vector removeFirst method, time complexity:
	// O(n)
	public T pop() {
		T first = data.getFirst();
		this.data.removeFirst();
		return first;
	}

	// Top method returns the first element of the Queue (which is the first
	// element of the vector)
	public T top() {
		T top = data.getFirst();
		return top;
	}

	// return the size of the Queue (i.e the size of the vector)
	public int size() {
		return data.size();
	}

	// Check if the Queue is empty
	public boolean empty() {
		return size() == 0;
	}

	// method that overloads the system.out.println method to be able to
	// directly print a Queue via System.out.println(myQueue)
	public String toString() {
		return this.data.toString();
	}
}
