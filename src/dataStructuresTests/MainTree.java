package dataStructuresTests;

import dataStructuresGenerics.Tree;

public class MainTree {

	public static void main(String[] args) {

		Tree<Integer> myTree = new Tree<Integer>();
		myTree.insert(0);
		for (int i = 1; i < 5; i++) {
			myTree.insert(-i);
			myTree.insert(i);
		}
		myTree.insert(10);
		myTree.insert(8);
		myTree.insert(7);

		myTree.print(false);

		System.out.println();

		System.out.println("Tree depth: " + myTree.maxDepth());

		System.out.println("Biggest element in tree: " + myTree.find_biggest());

		System.out.println("Tree size: " + myTree.size());

		System.out.println();

		myTree.swapTree();
		
		// print the tree, false for breadth first, true for width first
		myTree.print(false);

	}
}
