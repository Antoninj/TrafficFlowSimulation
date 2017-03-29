package dataStructuresGenerics;

public class LinkedList<T extends Comparable<T>> {

	/*
	 * Antonin Jousson
	 * 
	 * Linked list data structure.
	 */

	// Linked list are made of ListElement classes that corresponds to the
	// elements of the list. A ListElement is a box that contains an element and
	// a pointer to the next element of the list.
	private class ListElement<K extends Comparable<T>> {
		private K el1;
		private ListElement<K> el2;

		public ListElement(K el, ListElement<K> nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		public ListElement(K el) {
			this(el, null);
		}

		public K first() {
			return el1;
		}

		public ListElement<K> rest() {
			return el2;
		}

		public void setFirst(K value) {
			el1 = value;
		}

		public void setRest(ListElement<K> value) {
			el2 = value;
		}

	}

	private ListElement<T> head;
	private int count;

	// Constructor for an empty linked list
	public LinkedList() {
		head = null;
	}

	// method that returns the size of the Linked list
	public int size() {
		return count;
	}

	// method to check whether the linked list is empty or not (i.e contains any
	// element)
	public boolean isEmpty() {
		return size() == 0;
	}

	// method that returns the element at a given index
	public T get(int n) {
		ListElement<T> d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		return d.first();
	}

	// method that sets the element at a given index
	public void set(int n, T o) {
		ListElement<T> d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		d.setFirst(o);
	}

	// method that returns the head ListElement of the Linked list
	public ListElement<T> getHead() {
		return head;
	}

	// method that returns the first element of the Linked list
	public T getFirst() {
		return head.first();
	}

	// method that returns the last element of the Linked list
	public T getLast() {
		return this.get(this.size() - 1);
	}

	// method that adds a new element at the beginning of the Linked list
	public void addFirst(T o) {
		head = new ListElement<T>(o, head);
		count++;
	}

	// method that adds a new element at the end of the Linked list
	public void addLast(T o) {
		ListElement<T> el = new ListElement<T>(o, null);
		ListElement<T> d = head;
		if (this.size() > 0) {
			while (d.rest() != null) {
				d = d.rest();
			}
			d.setRest(el);
			count++;
		} else {
			addFirst(o);
		}
	}

	// method that removes the first element of the Linked list
	public void removeFirst() {
		if (this.size() > 0) {
			head = head.rest();
			count--;
		}
	}

	// method that removes the last element of the Linked list
	public void removeLast() {
		ListElement<T> d = head;
		if (this.size() > 0) {
			if (this.size() > 1) {
				while (d.rest().rest() != null) {
					d = d.rest();
				}
				d.setRest(null);
				count--;
			} else {
				removeFirst();
			}
		}
	}

	// method that adds T elements to the linked list in a sorted
	// manner
	public void addSorted(T o) {
		// an empty list, add element in front
		if (head == null)
			head = new ListElement<T>(o, null);
		else if (head.first().compareTo(o) > 0 || (head.first().compareTo(o) == 0)) {
			// we have to add the element in front
			head = new ListElement<T>(o, head);
		} else {
			// we have to find the first element which is bigger
			ListElement<T> d = head;
			while ((d.rest() != null) && (d.rest().first().compareTo(o) < 0)) {
				d = d.rest();
			}
			ListElement<T> next = d.rest();
			d.setRest(new ListElement<T>(o, next));
		}
		count++;
	}

	public void addSortedBinary(T o) {
		// an empty list, add element in front
		if (head == null)
			head = new ListElement<T>(o, null);
		else if (head.first().compareTo(o) == 0) {
			// we have to add the element in front
			head = new ListElement<T>(o, head);
		} else {
			// we have to add the element at the back
			ListElement<T> d = head;
			ListElement<T> next = d.rest();
			d.setRest(new ListElement<T>(o, next));
		}
		count++;

	}

	// method that removes an element
	public void removeElement(T element) {

		if (head.first().compareTo(element) == 0) {
			removeFirst();
		} else {
			ListElement<T> d = head;
			while (d.rest() != null) {
				if (d.rest().first().compareTo(element) == 0) {
					d.setRest(d.rest().rest());
				}
				if (d.rest() != null) {
					d = d.rest();
				}
			}
		}
		count--;
	}

	// method to find an object
	public T find(T element) {
		ListElement<T> d = head;
		int n = this.size();
		while (n > 0) {
			if (d.first().equals(element)) {
				return d.first();
			}
			d = d.rest();
		}
		return null;
	}

	// // method to check whether the linked list contains a given element or
	// not
	public T contains(T obj) {
		ListElement<T> d = head;
		int n = this.size();
		while (n > 0) {
			if (d.first().compareTo(obj) == 0) {
				return d.first();
			}
			d = d.rest();
			n--;
		}
		return null;
	}

	// method to print the linked list
	public void print() {
		System.out.print("(");
		ListElement<T> d = head;
		while (d != null) {
			System.out.print(d.first().toString() + " ");
			d = d.rest();
		}
		System.out.println(")");
	}

	// method that overloads the system.out.println method to be able to
	// directly print a linkedlist via System.out.println(myLinkedList)
	public String toString() {
		String s = "(";
		ListElement<T> d = head;
		while (d != null) {
			s = s + d.first().toString() + " ";
			d = d.rest();
		}
		s = s + ")";
		return s;
	}

	// method to reverse a linked list in place ( O(n^2) time complexity
	// achieved)
	public void reverse() {
		double half = Math.ceil(count / 2.0);
		for (int i = 0; i < half; i++) {
			T temp = this.get(i);
			this.set(i, this.get(count - i - 1));
			this.set(count - i - 1, temp);
		}
	}

	// O(n^2) implementation of the fropple method without manipulating pointers
	public void fropple() {
		for (int i = 0; i < count - 1; i++) {
			if (i % 2 == 0) {
				T temp = this.get(i);
				this.set(i, this.get(i + 1));
				this.set(i + 1, temp);
			}
		}
	}

	// O(n) implementation of the fropple method without manipulating pointers
	public void fropple2() {
		ListElement<T> d = head;
		for (int i = 0; i < count - 1; i = i + 2) {
			T temp = d.first();
			d.setFirst(d.rest().first());
			d.rest().setFirst(temp);
			d = d.rest().rest();
		}
	}

	// O(n) implementation of the fropple method by manipulating pointers
	public void fropple3() {

		ListElement<T> d = head;
		head = head.rest();
		while (d.rest() != null) {
			ListElement<T> temp1 = d;
			ListElement<T> temp2 = d.rest();
			System.out.println(temp1.first());
			System.out.println(temp2.first());
			d.rest().setRest(temp1);
			d = d.rest();
			d.setRest(temp2.rest());
		}
	}

	// method to append a linked list to the current linked list
	public void append(LinkedList<T> list2) {
		int n = list2.size() - 1;
		for (int i = 0; i <= n; i++) {
			T temp = list2.get(i);
			this.addLast(temp);
		}
	}
}
