package dataStructuresTests;

import dataStructuresGenerics.PriorityQueue;
import dataStructuresGenerics.PriorityQueueBinary;
import dataStructuresGenerics.PriorityQueueBST;

public class MainPriorityQueue {
	public static void main(String[] args) {

		System.out.println("******************* Sorted Priority queue tests ******************* ");
		System.out.println();

		PriorityQueue<Integer> myPriorityQueueSorted = new PriorityQueue<Integer>();

		myPriorityQueueSorted.push(1, 2);
		myPriorityQueueSorted.push(2, 4);
		myPriorityQueueSorted.push(3, 3);
		myPriorityQueueSorted.push(4, 6);
		myPriorityQueueSorted.push(5, 2);

		System.out.println(myPriorityQueueSorted);
		System.out.println("PriorityQueue size: " + myPriorityQueueSorted.size());
		System.out.println("Top element: " + myPriorityQueueSorted.top());
		System.out.println();

		myPriorityQueueSorted.pop();
		System.out.println("myPriorityQueueSorted.pop(): " + myPriorityQueueSorted);
		System.out.println("PriorityQueue size: " + myPriorityQueueSorted.size());
		System.out.println("Top element: " + myPriorityQueueSorted.top());

		System.out.println();
		System.out.println("******************* Unsorted Priority queue tests ******************* ");

		PriorityQueue<Integer> myPriorityQueueUnsorted = new PriorityQueue<Integer>();

		myPriorityQueueUnsorted.pushUnsorted(1, 2);
		myPriorityQueueUnsorted.pushUnsorted(2, 5);
		myPriorityQueueUnsorted.pushUnsorted(3, 4);
		myPriorityQueueUnsorted.pushUnsorted(4, 3);
		myPriorityQueueUnsorted.pushUnsorted(5, 1);

		System.out.println();
		System.out.println(myPriorityQueueUnsorted);
		System.out.println("PriorityQueue size: " + myPriorityQueueUnsorted.size());
		System.out.println("top element: " + myPriorityQueueUnsorted.topUnsorted());
		System.out.println();

		myPriorityQueueUnsorted.popUnsorted();
		System.out.println(myPriorityQueueUnsorted);
		System.out.println("PriorityQueue size: " + myPriorityQueueUnsorted.size());
		System.out.println("top element: " + myPriorityQueueUnsorted.topUnsorted());

		System.out.println();
		System.out.println("******************* Dual Priority queue tests ******************* ");

		// This is not working at the moment
		
		PriorityQueueBinary myPriorityQueuebinary = new PriorityQueueBinary();

		myPriorityQueuebinary.push(1, true);
		myPriorityQueuebinary.push(2, false);
		myPriorityQueuebinary.push(3, true);
		myPriorityQueuebinary.push(4, false);
		myPriorityQueuebinary.push(5, true);

		System.out.println();
		System.out.println(myPriorityQueuebinary);
		System.out.println("PriorityQueue size: " + myPriorityQueuebinary.size());
		System.out.println("top element: " + myPriorityQueuebinary.top());
		System.out.println();

		myPriorityQueuebinary.pop();
		System.out.println(myPriorityQueuebinary);
		System.out.println("PriorityQueue size: " + myPriorityQueuebinary.size());
		System.out.println("top element: " + myPriorityQueuebinary.top());
		System.out.println();

		System.out.println("******************* Binary Search Tree based Priority queue tests ******************* ");

		PriorityQueueBST<Integer> myBSTPriorityQueue = new PriorityQueueBST<Integer>();

		myBSTPriorityQueue.push(1, 2);
		myBSTPriorityQueue.push(2, 1);
		myBSTPriorityQueue.push(10, 3);
		myBSTPriorityQueue.push(4, 5);
		myBSTPriorityQueue.push(5, 4);

		System.out.println();
		myBSTPriorityQueue.print(false);
		System.out.println();

		System.out.println("PriorityQueue size: " + myBSTPriorityQueue.size());
		System.out.println("Top element: " + myBSTPriorityQueue.top());
		System.out.println();

		myBSTPriorityQueue.pop();
		myBSTPriorityQueue.print(false);
		System.out.println();
		System.out.println("PriorityQueue size: " + myBSTPriorityQueue.size());
		System.out.println("Top element: " + myBSTPriorityQueue.top());
		System.out.println();

	}

}