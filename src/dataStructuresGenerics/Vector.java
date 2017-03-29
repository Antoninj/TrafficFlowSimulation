package dataStructuresGenerics;

public class Vector<T extends Object> {

	/*
	 * Antonin Jousson
	 * 
	 * Vector data structure.
	 */

	private T[] data;
	private int count;

	// constructor
	public Vector(int capacity) {
		data = (T[])new Object[capacity];
		count = 0;
	}

	// method to extend the capacity of the vector
	private void extendCapacity() {
		T[] data2 = (T[]) new Object[2 * size()];
		for (int i = 0; i < size(); i++) {
			data2[i] = this.get(i);
		}
		this.data = data2;
	}

	// method that returns the size of the vector
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
		if (index < this.size() && index >= 0) {
			return data[index];
		} else
			return (T)"Index out of bounds";
	}

	// method that sets the element at a given index
	public void set(int index, T obj) {
			data[index] = obj;
	}

	// method that returns the first element of the vector
	public T getFirst() {
		return this.get(0);
	}

	// method that returns the last element of the vector
	public T getLast() {
		return this.get(size() - 1);
	}

	// method that adds a new element at the beginning of the vector
	public void addFirst(T obj) {
		if (data.length == size()) {
			this.extendCapacity();
		}
		for (int i = size(); i > 0; i--) {
			this.set(i, this.get(i - 1));
		}
		this.set(0, obj);
		count++;
	}

	// method that adds a new element at the end of the vector
	public void addLast(T obj) {
		if (data.length == size()) {
			this.extendCapacity();
		}
		this.set(size(), obj);
		count++;
	}

	// method that removes the first element of the vector
	public void removeFirst() {
		if (size() > 0) {
			for (int i = 0; i < size()-1; i++) {
				this.set(i, this.get(i + 1));
			}
			count--;
		}
	}

	// method that removes the last element of the vector
	public void removeLast() {
		if (size() > 0) {
			this.set(size()-1, null);
			count--;
		}
	}

	// method to check whether the vector contains a given element or not
	public T contains(T obj) {
		for (int i = 0; i < size(); i++) {
			if (this.get(i).equals(obj)) {
				return obj;
			}
		}
		return null;
	}

	// method that overloads the system.out.println method to be able to
	// directly print a vector via System.out.println(myVector)
	public String toString() {
		String s = "[";
		for (int i = 0; i < size(); i++) {
			if (i != size() - 1) {
				s = s + this.get(i) + ",";
			} else {
				s = s + this.get(i);
			}
		}
		s = s + "]";
		return s;
	}

	// method that inserts a new element at a given position of the vector
	public void insert(int index, T obj) {
		if (data.length == size()) {
			this.extendCapacity();
		}
		for (int i = size(); i >= index; i--) {
			this.set(i + 1, this.get(i));
		}
		this.set(index, obj);
		count++;
	}

	// method to reverse a vector in place
	public void reverse() {
		double half = Math.ceil(size() / 2.0);
		for (int i = 0; i < half; i++) {
			T temp = this.get(i);
			this.set(i, this.get(size() - i - 1));
			this.set(size() - i - 1, temp);
		}
	}

	// method that doubles each element of a vector
	public Vector<T> vectorDouble() {
		Vector<T> doubleVector = new Vector<T>(size() * 2);
		for (int i = 0; i < size(); i++) {
			doubleVector.set(2 * i, this.get(i));
			doubleVector.set(2 * i + 1, this.get(i));
		}
		doubleVector.count = size() * 2;
		return doubleVector;
	}

	// method that interleaves a vector with another vector
	public Vector<T> vectorInterleave(Vector<T> v2) {
		Vector<T> interleaveVector = new Vector<T>(this.size() * 2);
		for (int i = 0; i < size(); i++) {
			interleaveVector.set(2 * i, this.get(i));
			interleaveVector.set(2 * i + 1, v2.get(i));
		}
		interleaveVector.count = this.size() * 2;
		return interleaveVector;
	}

	// method that runs a binary search of a specific element in a vector
	public boolean binarySearch(Comparable key) {
		int start = 0;
		int end = size() - 1;
		while (start <= end) {
			int middle = (start + end + 1) / 2;
			if (key.compareTo(data[middle]) > 0) {
				end = middle - 1;
			} else if (key.compareTo(data[middle]) < 0) {
				start = middle + 1;
			} else
				return true;
		}
		return false;
	}
}
