package dataStructuresGenerics;

public class CircularVector<T extends Object> {

	/*
	 * Antonin Jousson
	 * 
	 * Circular Vector data structure.
	 */

	private T data[];
	private int first;
	private int count;
	private int capacity;

	// Constructor
	public CircularVector(int capacity) {
		count = 0;
		first = 0;
		data = (T[]) new Object[capacity];
		this.capacity = capacity;
	}

	// method that returns the size of the circular vector
	public int size() {
		return count;
	}

	// method to check whether the vector is empty or not (i.e contains any
	// element)
	public boolean isEmpty() {
		return size() == 0;
	}

	// method that returns the element at a given index
	public T get(int index) {
		return data[index];
	}

	// method that sets the element at a given index
	public void set(int index, T obj) {
		data[index] = obj;
	}

	// method that returns the first element of the circular vector
	public T getFirst() {
		return this.get(first);
	}

	// method that returns the last element of the circular vector
	public T getLast() {
		return this.get((first + size()) % capacity - 1);
	}

	// method that adds a new element at the beginning of the circular vector
	public void addFirst(T element) {

		if (this.size() == 0) {
			this.set(first, element);
			count++;
		} else {
			first = (first + capacity - 1) % capacity;
			this.set(first, element);
			count++;
		}
	}

	// method that adds a new element at the end of the circular vector
	public void addLast(T element) {

		if (this.size() == 0) {
			this.set(size(), element);
			count++;
		} else {
			this.set((first + size()) % capacity, element);
			count++;
		}
	}

	// method that removes the first element of the circular vector
	public void removeFirst() {
		if (count > 0) {
			first = (first + 1) % capacity;
			count--;
		}
	}

	// method that removes the last element of the circular vector
	public void removeLast() {
		if (count > 0) {
			count--;
		}
	}

	// method to check whether the circular vector contains a given element or
	// not
	public boolean contains(T obj) {
		for (int i = 0; i < size(); i++) {
			if (this.get(i).equals(obj)) {
				return true;
			}
		}
		return false;
	}

	public void print() {
		System.out.print("[");
		for (int i = 0; i < count; i++) {
			int index = (first + i) % capacity;
			System.out.print(this.get(index) + " ");
		}
		System.out.println("]");
	}

	// method that overloads the system.out.println method to be able to
	// directly print a circular vector via System.out.println(myCircularVector)
	public String toString() {
		String s = "[";
		for (int i = 0; i < count; i++) {
			int index = (first + i) % capacity;
			s = s + this.get(index) + " ";
		}
		s = s + "]";
		return s;
	}
}