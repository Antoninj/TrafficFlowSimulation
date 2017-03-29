package dataStructuresTests;

import dataStructuresGenerics.Graph;
import dataStructuresGenerics.LinkedList;
import dataStructuresGenerics.StackLl;

public class MainGraph {

	public static void main(String[] args) {

		Graph myGraph = new Graph();

		for (int i = 1; i < 7; i++) {
			myGraph.addNode("node" + i);
		}

		myGraph.addEdge("node1", "node2", 2, "East");
		myGraph.addEdge("node1", "node4", 4, "South");

		myGraph.addEdge("node2", "node1", 8, "West");
		myGraph.addEdge("node2", "node3", 11, "East");
		myGraph.addEdge("node2", "node5", 10, "South");

		myGraph.addEdge("node3", "node2", 3, "West");
		myGraph.addEdge("node3", "node6", 4, "South");

		myGraph.addEdge("node4", "node5", 2, "East");
		myGraph.addEdge("node4", "node1", 1, "North");

		myGraph.addEdge("node5", "node2", 7, "North");
		myGraph.addEdge("node5", "node4", 4, "West");
		myGraph.addEdge("node5", "node6", 3, "East");

		myGraph.addEdge("node6", "node5", 2, "West");
		myGraph.addEdge("node6", "node3", 5, "North");

		System.out.println(myGraph);

		// myGraph.print();
		// System.out.println(myGraph.findPath("node1", "node2"));
		// System.out.println(myGraph.findPath("node1", "node4"));

		System.out.println();

		LinkedList<String>[] paths = myGraph.shortestPath("node6");

		for (int i = 0; i < paths.length; i++) {
			System.out.println(paths[i]);
		}
		
		StackLl<String>[] edgepaths = myGraph.getEdgePath(paths);
		System.out.println();

		for (int i = 0; i < edgepaths.length; i++) {
			System.out.println(edgepaths[i]);
		}

	}
}
