package dataStructuresTests;

import dataStructuresGenerics.Dictionary;
import dataStructuresGenerics.DictionaryTree;

public class MainDictionary {

	public static void main(String[] args) {

		// Linked list based dictionary tests

		Dictionary myDictionary = new Dictionary();

		myDictionary.add("Time", 10);
		myDictionary.add("Animal", "cat");
		myDictionary.add("Name", "Antonin");

		System.out.println(myDictionary);

		System.out.println(myDictionary.findPosition("Name"));
		System.out.println(myDictionary.findPosition("Unknown"));
		String test = "Name";
		System.out.println(myDictionary.find(test));

		myDictionary.add("Name", "Antonin");
		myDictionary.add("Age", "24");
		myDictionary.add("Age", "23");
		System.out.println(myDictionary);

		System.out.println();

		// Binary Tree based dictionary tests

		DictionaryTree myTreeDictionary = new DictionaryTree();

		myTreeDictionary.add("Time", 10);
		myTreeDictionary.add("Animal", "Cat");
		myTreeDictionary.add("Name", "Antonin");

		myTreeDictionary.print(true);

		System.out.println(myTreeDictionary.find("Name"));

	}
}
