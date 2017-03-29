package dataStructuresTests;

import dataStructuresGenerics.Queue;
import dataStructuresGenerics.QueueLl;

public class MainQueue {
	public static void main(String[] args) {

		System.out.println("******************* Circular Vector based Queue ******************* ");
		Queue<Integer> myQueue = new Queue<Integer>(100);

		for (int i = 1; i <= 10; i++) {
			myQueue.push(i);
		}
		System.out.println();
		System.out.println("myQueue: " + myQueue);
		System.out.println("Queue size: " + myQueue.size());
		System.out.println("top element: " + myQueue.top());
		System.out.println();

		myQueue.pop();
		System.out.println("myQueue.pop: " + myQueue);
		System.out.println("Queue size: " + myQueue.size());
		System.out.println("top element: " + myQueue.top());
		System.out.println();

		System.out.println("******************* Linked list based Queue *******************");

		QueueLl<Integer> myQueue2 = new QueueLl<Integer>();

		for (int i = 1; i <= 10; i++) {
			myQueue2.push(i);
		}

		System.out.println();
		System.out.println("myQueue: " + myQueue2);
		System.out.println("Queue size: " + myQueue2.size());
		System.out.println("top element: " + myQueue2.top());
		System.out.println();

		myQueue2.pop();
		System.out.println("myQueue.pop: " + myQueue2);
		System.out.println("Queue size: " + myQueue2.size());
		System.out.println("top element: " + myQueue2.top());
		System.out.println();

		myQueue2.pop();
		System.out.println("myQueue.pop: " + myQueue2);
		System.out.println("Queue size: " + myQueue2.size());
		System.out.println("top element: " + myQueue2.top());
		System.out.println(myQueue2.empty());

	}

}
