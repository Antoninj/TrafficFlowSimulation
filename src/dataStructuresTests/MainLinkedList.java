package dataStructuresTests;

import dataStructuresGenerics.LinkedList;

public class MainLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> myList = new LinkedList<Integer>();
		LinkedList<Integer> emptyList = new LinkedList<Integer>();
		
		for (int i = 10; i >= 0; i--) {
			myList.addFirst(i);
		}

		System.out
				.println("******************* Test of 'addFirst', 'toString' and 'size' methods ******************* ");

		System.out.println();
		System.out.println("myList: " + myList);
		System.out.println("myList.size(): " + myList.size());
		System.out.println();
		
		System.out.println("******************* Test of 'contains' and 'isEmpty' methods  ******************* ");

		System.out.println();
		System.out.println("myList: " + myList);
		System.out.println("myList.contains(6): " + myList.contains(6));
		System.out.println("myList.contains(50): " + myList.contains(50));
		System.out.println();

		System.out.println("myList: " + myList);
		System.out.println("emptyList: " + emptyList);
		System.out.println("myList.isEmpty(): " + myList.isEmpty());
		System.out.println("emptyList.isEmpty(): " + emptyList.isEmpty());
		System.out.println();

		System.out.println("******************* Test of 'getFirst' and 'getLast' methods ******************* ");

		System.out.println();
		System.out.println("myList: " + myList);
		System.out.println("myList.getFirst(): " + myList.getFirst());
		System.out.println("myList.getLast(): " + myList.getLast());
		System.out.println();

		System.out.println(
				"******************* Test of 'addLast', 'removeFirst' and 'removeLast'  methods ******************* ");

		System.out.println();
		System.out.println("myList: " + myList);
		myList.addLast(11);
		System.out.println("myList.addLast(11): " + myList);
		System.out.println("Linked list size: " + myList.size());
		System.out.println();

		System.out.println("myList: " + myList);
		myList.removeFirst();
		System.out.println("myList.removeFirst(): " + myList);
		System.out.println("Linked list size: " + myList.size());
		System.out.println();

		System.out.println("myList: " + myList);
		myList.removeLast();
		System.out.println("myList.removeLast(): " + myList);
		System.out.println("Linked list size: " + myList.size());
		System.out.println();

		System.out.println("******************* Test of 'addSorted' and 'removeElement' methods  ******************* ");

		LinkedList<Integer> sortedList = new LinkedList<Integer>();

		System.out.println();
		sortedList.addSorted(5);
		System.out.println("sortedList.addSorted(5): " + sortedList);
		sortedList.addSorted(4);
		System.out.println("sortedList.addSorted(4): " + sortedList);
		sortedList.addSorted(1);
		System.out.println("sortedList.addSorted(1): " + sortedList);
		sortedList.addSorted(3);
		System.out.println("sortedList.addSorted(3): " + sortedList);
		sortedList.addSorted(2);
		System.out.println("sortedList.addSorted(2): " + sortedList);
		System.out.println("Linked list size: " + sortedList.size());
		System.out.println();

		sortedList.removeElement(2);
		System.out.println("sortedList.removeElement(2): " + sortedList);
		System.out.println("Linked list size: " + sortedList.size());
		System.out.println();

		System.out
				.println("******************* Test of 'reverse', 'fropple' and 'append' methods ******************* ");

		System.out.println();
		System.out.println("myList: " + myList);
		myList.reverse();
		System.out.println("myList.reverse(): " + myList);
		System.out.println("Linked list size: " + myList.size());
		System.out.println();

		myList.reverse(); 		// put list back in right order
		myList.addLast(11);
		System.out.println("myList: " + myList);
		myList.fropple2();
		System.out.println("myList.fropple2(): " + myList);
		System.out.println("Linked list size: " + myList.size());

		System.out.println();

		LinkedList<Integer> myList2 = new LinkedList<Integer>();

		for (int i = 15; i >= 11; i--) {
			myList2.addFirst(i);
		}

		myList.fropple2();
		System.out.println("myList: " + myList);
		System.out.println("myList2: " + myList2);
		myList.append(myList2);
		System.out.println("myList.append(myList2): " + myList);
		System.out.println("Linked list size: " + myList.size());

	}
}
