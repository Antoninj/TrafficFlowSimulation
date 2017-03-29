package dataStructuresTests;

import dataStructuresGenerics.Vector;

public class MainVector {

	public static void main(String[] args) {

		Vector<Integer> myVector = new Vector<Integer>(100);
		Vector<Integer> emptyVector = new Vector<Integer>(100);

		for (int i = 1; i <= 10; i++) {
			myVector.addLast(i);
		}

		System.out.println("******************* Test of 'addLast', 'toString' and 'size' methods ******************* ");

		System.out.println();
		System.out.println("myVector: " + myVector);
		System.out.println("myVector.size(): " + myVector.size());
		System.out.println();

		System.out.println("******************* Test of 'contains' and 'isEmpty' method  ******************* ");

		System.out.println();
		System.out.println("myVector: " + myVector);
		System.out.println("myVector.contains(6): " + myVector.contains(6));
		System.out.println("myVector.contains(50): " + myVector.contains(50));
		System.out.println();

		System.out.println("myVector: " + myVector);
		System.out.println("emptyVector: " + emptyVector);
		System.out.println("myVector.isEmpty(): " + myVector.isEmpty());
		System.out.println("emptyVector.isEmpty(): " + emptyVector.isEmpty());
		System.out.println();

		System.out.println("******************* Test of 'getFirst' and 'getLast' methods ******************* ");

		System.out.println();
		System.out.println("myVector: " + myVector);
		System.out.println("myVector.getFirst(): " + myVector.getFirst());
		System.out.println("myVector.getLast(): " + myVector.getLast());
		System.out.println();

		System.out.println(
				"******************* Test of 'addFirst', 'removeFirst' and 'removeLast'  methods ******************* ");

		System.out.println();
		System.out.println("myVector: " + myVector);
		myVector.addFirst(6);
		System.out.println("myVector.addFirst(6): " + myVector);
		System.out.println("Vector size: " + myVector.size());
		System.out.println();

		System.out.println("myVector: " + myVector);
		myVector.removeFirst();
		System.out.println("myVector.removeFirst(): " + myVector);
		System.out.println("Vector size: " + myVector.size());
		System.out.println();

		System.out.println("myVector: " + myVector);
		myVector.removeLast();
		System.out.println("myVector.removeLast(): " + myVector);
		System.out.println("Vector size: " + myVector.size());
		System.out.println();

		System.out.println(
				"******************* Test of 'reverse', 'doubleVector' and 'vectorInterleave' methods ******************* ");

		System.out.println();
		System.out.println("myVector: " + myVector);
		myVector.reverse();
		System.out.println("myVector.reverse(): " + myVector);
		System.out.println("Vector size: " + myVector.size());
		System.out.println();

		System.out.println("myVector: " + myVector);
		myVector.reverse();
		Vector<Integer> doubleVector = myVector.vectorDouble();
		System.out.println("doubleVector: " + doubleVector);
		System.out.println("Vector size: " + doubleVector.size());
		System.out.println();

		Vector<Integer> v1 = new Vector<Integer>(3);

		for (int i = 1; i <= 3; i++) {
			v1.addLast(i);
		}

		Vector<Integer> v2 = new Vector<Integer>(3);

		v2.addLast(4);
		v2.addLast(5);
		v2.addLast(6);

		Vector<Integer> v3 = v1.vectorInterleave(v2);
		System.out.println("v1: " + v1);
		System.out.println("v2: " + v2);
		System.out.println("v1.vectorInterleave(v2): " + v3);
		System.out.println("Vector size: " + v3.size());
		System.out.println();

		System.out.println(
				"******************* Test of 'extendCapacity', 'insert' and 'binarySearch' methods ******************* ");

		System.out.println();
		System.out.println("v3: " + v3);
		v3.addLast(3);
		System.out.println("v3.addLast(3): " + v3);
		System.out.println("Vector size: " + v3.size());
		System.out.println();

		System.out.println("v3: " + v3);
		v3.insert(1, 2);
		System.out.println("v3.insert(1,2): " + v3);
		System.out.println(v3);
		System.out.println("Vector size: " + v3.size());
		System.out.println();

		System.out.println("myVector: " + myVector);
		myVector.binarySearch(2);
		System.out.println("myVector.binarySearch(2): " + myVector.binarySearch(2));
		System.out.println("myVector.binarySearch(10): " + myVector.binarySearch(10));

	}
}