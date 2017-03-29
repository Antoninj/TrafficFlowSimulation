package dataStructuresTests;

import dataStructuresGenerics.Stack;
import dataStructuresGenerics.StackLl;

public class MainStack {
	public static void main(String[] args) {

		System.out.println("******************* Vector based Stack ******************* ");

		Stack<Integer> myStack = new Stack<Integer>(10);

		for (int i = 1; i <= 10; i++) {
			myStack.push(i);
		}

		System.out.println();
		System.out.println("myStack: " + myStack);
		System.out.println("Stack size: " + myStack.size());
		System.out.println("top element: " + myStack.top());
		System.out.println();

		myStack.pop();
		System.out.println("myStack.pop: " + myStack);
		System.out.println("Stack size: " + myStack.size());
		System.out.println("top element: " + myStack.top());
		System.out.println();

		System.out.println("******************* Linked list based Stack *******************");

		StackLl<Integer> myStack2 = new StackLl<Integer>();

		for (int i = 1; i <= 10; i++) {
			myStack2.push(i);
		}

		System.out.println();
		System.out.println("myStack: " + myStack2);
		System.out.println("Stack size: " + myStack2.size());
		System.out.println("top element: " + myStack2.top());
		myStack2.pop();

		System.out.println();
		System.out.println("myStack.pop: " + myStack2);
		System.out.println("Stack size: " + myStack2.size());
		System.out.println("top element: " + myStack2.top());

	}

}
