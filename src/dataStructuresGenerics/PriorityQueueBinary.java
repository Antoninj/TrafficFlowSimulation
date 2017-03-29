package dataStructuresGenerics;

public class PriorityQueueBinary {

	/*
	 * Antonin Jousson
	 * 
	 * Dual priorities Priority Queue data structure.
	 */
	
	public class PriorityPair implements Comparable {
		public Comparable element;
		public Comparable priority;

		public PriorityPair(Comparable element, Comparable priority) {
			this.element = element;
			this.priority = priority;
		}

		public int compareTo(Object o) {
			PriorityPair p2 = (PriorityPair) o;
			return ((Comparable) priority).compareTo(p2.priority);
		}

		public String toString() {
			String s = "(" + this.element.toString() + "," + this.priority.toString() + ")";
			return s;
		}

	}

	private LinkedList data;

	public PriorityQueueBinary() {
		data = new LinkedList();
	}

	public int size() {
		return data.size();
	}

	public void push(Comparable o, boolean priority) {
		PriorityPair pp = new PriorityPair(o, priority);
		this.data.addSortedBinary(pp);
	}

	public Comparable pop() {
		Comparable last = data.getLast();
		this.data.removeLast();
		return last;
	}

	public Comparable top() {
		Comparable top = data.getLast();
		return top;
	}

	public String toString() {
		return this.data.toString();
	}
}