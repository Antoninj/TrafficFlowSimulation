package dataStructuresGenerics;

public class PriorityQueueBST<T extends Comparable<T>> {

	/*
	 * Antonin Jousson
	 * 
	 * Priority Queue data structure based on binary search tree
	 */

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

		public int compareTo(PriorityQueueBST<T>.PriorityPair<K> o) {
			return (this.priority - o.getPriority());
		}

	}

	private Tree<PriorityPair<T>> data;

	// Priority queue constructor calls the empty tree constructor
	public PriorityQueueBST() {
		data = new Tree<PriorityPair<T>>();
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
		data.insert(pp);
	}

	// Method that returns the top priority element and removes it.
	public T pop() {
		T top = data.find_biggest().getElement();
		this.data.remove_biggest();
		return top;
	}

	// Method that returns the top priority element.
	public T top() {
		T top = data.find_biggest().getElement();
		return top;
	}

	public void print(boolean width) {
		this.data.print(width);
	}
}