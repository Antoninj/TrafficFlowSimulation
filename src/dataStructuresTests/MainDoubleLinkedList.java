package dataStructuresTests;

import dataStructuresGenerics.DoubleLinkedList;

public class MainDoubleLinkedList {

	public static void main(String[] args) {

		DoubleLinkedList myDoubleList = new DoubleLinkedList();
		DoubleLinkedList myDoubleList2 = new DoubleLinkedList();
		DoubleLinkedList emptyDoubleList = new DoubleLinkedList();

		for (int i = 4; i >= 1; i--) {
			myDoubleList.addFirst(i);
		}

		myDoubleList2.addFirst(1);

		System.out
				.println("******************* Test of 'addFirst', 'toString' and 'size' methods ******************* ");

		System.out.println();
		System.out.println("myDoubleList: " + myDoubleList);
		System.out.println("myDoubleList.size(): " + myDoubleList.size());
		System.out.println();

		System.out.println("******************* Test of 'printReverse' and 'isEmpty' method  ******************* ");

		System.out.println();
		System.out.print("myDoubleList.printReverse(): ");
		myDoubleList.printReverse();
		System.out.println();

		System.out.println("myDoubleList: " + myDoubleList);
		System.out.println("emptyList: " + emptyDoubleList);
		System.out.println("myDoubleList.isEmpty(): " + myDoubleList.isEmpty());
		System.out.println("emptyList.isEmpty(): " + emptyDoubleList.isEmpty());
		System.out.println();

		System.out.println("******************* Test of 'getFirst' and 'getLast' methods ******************* ");

		System.out.println();
		System.out.println("myDoubleList: " + myDoubleList);
		System.out.println("myDoubleList.getFirst(): " + myDoubleList.getFirst());
		System.out.println("myDoubleList.getLast(): " + myDoubleList.getLast());
		System.out.println();

		System.out.println(
				"******************* Test of 'addLast', 'removeFirst' and 'removeLast'  methods ******************* ");

		System.out.println();
		System.out.println("myDoubleList: " + myDoubleList);
		myDoubleList.addLast(5);
		System.out.println("myDoubleList.addLast(5): " + myDoubleList);
		System.out.println("Linked list size: " + myDoubleList.size());
		System.out.println();

		System.out.println("myDoubleList: " + myDoubleList);
		myDoubleList.removeFirst();
		System.out.println("myDoubleList.removeFirst(): " + myDoubleList);
		System.out.println("Linked list size: " + myDoubleList.size());
		System.out.println();

		System.out.println("myDoubleList2: " + myDoubleList2);
		myDoubleList2.removeFirst();
		System.out.println("myDoubleList2.removeFirst(): " + myDoubleList2);
		System.out.println("Linked list size: " + myDoubleList2.size());
		System.out.println();

		System.out.println("myDoubleList: " + myDoubleList);
		myDoubleList.removeLast();
		System.out.println("myList.removeLast(): " + myDoubleList);
		System.out.println("Linked list size: " + myDoubleList.size());
		System.out.println();

		System.out.println("******************* Test of 'reverse' method  ******************* ");

		myDoubleList.addFirst(1);
		myDoubleList.addLast(5);
		myDoubleList.addLast(6);

		System.out.println();
		System.out.println("myDoubleList: " + myDoubleList);
		myDoubleList.reverse();
		System.out.println("myList.reverse(): " + myDoubleList);
		System.out.println("Linked list size: " + myDoubleList.size());
		System.out.println();

	}

}
