package dataStructuresGenerics;

public class PriorityQueue<T extends Comparable<T>> {

	/*
	 * Antonin Jousson
	 * 
	 * Priority Queue data structure.
	 */

	// A priority Queue is a Linked list that has Prioriy pairs list elements

	private class PriorityPair<K> implements Comparable<PriorityPair<K>> {
		private K element;
		private int priority;

		private PriorityPair(K element, int priority) {
			this.element = element;
			this.priority = priority;
		}

		public int getPriority() {
			return this.priority;
		}

		public K getElement() {
			return this.element;
		}

		public String toString() {
			String s = "[" + this.element.toString() + ", priority:" + this.priority + "]";
			return s;
		}

		@Override
		public int compareTo(PriorityQueue<T>.PriorityPair<K> pair) {
			return (this.priority - pair.getPriority());
		}
	}

	private LinkedList<PriorityPair<T>> data;

	// Priority queue constructor calls the empty linked list constructor
	public PriorityQueue() {
		data = new LinkedList<PriorityPair<T>>();
	}

	// returns the size of the Priority queue
	public int size() {
		return data.size();
	}

	// ***************** Sorted Priority queue Implementation *****************

	// The push method adds element to the queue sorted by priority : The
	// highest priority element will be added at the end of the linked list.
	// Time complexity : O(n)

	public void push(T o, int priority) {
		PriorityPair<T> pp = new PriorityPair<T>(o, priority);
		data.addSorted(pp);
	}

	// Method that returns the top priority element and removes it.
	public T pop() {
		T last = data.getLast().getElement();
		this.data.removeLast();
		return last;
	}

	// Method that returns the top priority element.
	public T top() {
		T top = data.getLast().getElement();
		return top;
	}

	public String toString() {
		return this.data.toString();
	}

	// ***************** Unsorted Priority queue Implementation
	// *****************

	public void pushUnsorted(T o, int priority) {
		PriorityPair<T> pp = new PriorityPair<T>(o, priority);
		this.data.addLast(pp);
	}

	public T popUnsorted() {
		int index = 0;
		for (int i = 0; i < this.data.size() - 1; i++) {
			if (this.data.get(i).compareTo(this.data.get(i + 1)) < 0) {
				index = i + 1;
			}
		}
		PriorityPair<T> top = this.data.get(index);
		this.data.removeElement(top);
		return top.getElement();
	}

	public T topUnsorted() {
		int index = 0;
		for (int i = 0; i < this.data.size() - 1; i++) {
			if (this.data.get(i).compareTo(this.data.get(i + 1)) < 0) {
				index = i + 1;
			}
		}
		PriorityPair<T> top = this.data.get(index);
		return top.getElement();
	}
}