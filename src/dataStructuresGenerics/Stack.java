package dataStructuresGenerics;

public class Stack<T>{

	/*
	 * Antonin Jousson
	 * 
	 * Vector based Stack data structure.
	 */

	private Vector<T> data;

	// constructor that calls the Vector constructor
	public Stack(int capacity) {
		data = new Vector<T>(capacity);
	}

	// Push method that calls the vector addLast method, time complexity : O(1)
	public void push(T o) {
		this.data.addLast(o);

	}

	// Pop method that calls the vector removeLast method, time complexity :
	// O(1)
	public T pop() {
		T last = data.getLast();
		this.data.removeLast();
		return last;
	}

	// Top method returns the first element of the Stack (which is the last
	// element of the vector)
	public T top() {
		T top = data.getLast();
		return top;
	}

	// return the size of the Stack (i.e the size of the vector)
	public int size() {
		return data.size();
	}

	// Check if the Stack is empty
	public boolean empty() {
		return size() == 0;
	}

	// method that overloads the system.out.println method to be able to
	// directly print a Stack via System.out.println(myStack)
	public String toString() {
		return this.data.toString();
	}
}
