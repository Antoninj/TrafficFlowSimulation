package dataStructuresGenerics;

public class DoubleLinkedList {

	/*
	 * Antonin Jousson
	 * 
	 * Double Linked List data structure.
	 */

	private class DoubleLinkedListElement {
		private Object data;
		private DoubleLinkedListElement nextElement;
		private DoubleLinkedListElement previousElement;

		public DoubleLinkedListElement(Object v, DoubleLinkedListElement next, DoubleLinkedListElement previous)

		{
			data = v;
			nextElement = next;
			previousElement = previous;

			if (nextElement != null)
				nextElement.previousElement = this;
			if (previousElement != null)
				previousElement.nextElement = this;
		}

		public DoubleLinkedListElement(Object v) {
			this(v, null, null);
		}

		public DoubleLinkedListElement previous() {
			return previousElement;
		}

		public Object value() {
			return data;
		}

		public DoubleLinkedListElement next() {
			return nextElement;
		}

		public void setNext(DoubleLinkedListElement value) {
			nextElement = value;
		}

		public void setPrevious(DoubleLinkedListElement value) {
			previousElement = value;
		}

	}

	private int count;
	private DoubleLinkedListElement head;
	private DoubleLinkedListElement tail;

	public DoubleLinkedList() {
		head = null;
		tail = null;
		count = 0;
	}

	public int size() {
		return count;
	}

	// method to check whether the linked list is empty or not (i.e contains any
	// element)
	public boolean isEmpty() {
		return size() == 0;
	}

	public Object getFirst() {
		return head.value();
	}

	public Object getLast() {
		return tail.value();
	}

	public void addFirst(Object value) {
		head = new DoubleLinkedListElement(value, head, null);
		if (tail == null)
			tail = head;
		count++;
	}

	public void addLast(Object value) {
		tail = new DoubleLinkedListElement(value, null, tail);
		if (head == null)
			head = tail;
		count++;
	}

	public void removeFirst() {
		head = head.next();
		if (head == null)
			tail = null;
		else
			head.setPrevious(null);
		count--;
	}

	public void removeLast() {
		tail = tail.previous();
		if (tail == null)
			head = null;
		else
			tail.setNext(null);
		count--;
	}

	public void reverse() {
		DoubleLinkedListElement temp = head;
		head = tail;
		tail = temp;
		DoubleLinkedListElement d = head;
		while (d != null) {
			temp = d.next();
			d.setNext(d.previous());
			d.setPrevious(temp);
			d = d.next();
		}
	}

	public void print() {
		DoubleLinkedListElement d = head;
		System.out.print("(");
		while (d != null) {
			System.out.print(d.value() + " ");
			d = d.next();
		}
		System.out.println(")");
	}

	public void printReverse() {
		DoubleLinkedListElement d = tail;
		System.out.print("(");
		while (d != null) {
			System.out.print(d.value() + " ");
			d = d.previous();
		}
		System.out.println(")");
	}

	public String toString() {
		DoubleLinkedListElement d = head;
		String s = "(";
		while (d != null) {
			s = s + d.value().toString() + " ";
			d = d.next();
		}
		s = s + ")";
		return s;
	}
}
