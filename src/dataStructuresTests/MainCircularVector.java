package dataStructuresTests;

import dataStructuresGenerics.CircularVector;

public class MainCircularVector {

	public static void main(String[] args) {

		CircularVector<Integer> mycv = new CircularVector<Integer>(10);

		for (int i = 1; i <= 4; i++) {
			mycv.addLast(i);
		}

		System.out.println(mycv);
		System.out.println("First item of the vector: " + mycv.getFirst());
		System.out.println("Last item of the vector: " + mycv.getLast());
		System.out.println("Circular vector size: " + mycv.size());
		System.out.println();

		mycv.removeFirst();
		mycv.addLast(5);
		mycv.addLast(6);

		System.out.println(mycv);
		System.out.println("First item of the vector: " + mycv.getFirst());
		System.out.println("Last item of the vector: " + mycv.getLast());
		System.out.println("Circular vector size: " + mycv.size());
		System.out.println();

		mycv.removeLast();
		mycv.addFirst(10);
		mycv.addFirst(11);

		System.out.println(mycv);
		System.out.println("First item of the vector: " + mycv.getFirst());
		System.out.println("Last item of the vector: " + mycv.getLast());
		System.out.println("Circular vector size: " + mycv.size());
		System.out.println();
	}

}
