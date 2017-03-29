package dataStructuresGenerics;

public class Graph {

	private class Node implements Comparable<Node> {
		private Comparable info;
		private LinkedList<Edge> edges;
		private boolean visited;

		public Node(Comparable label) {
			info = label;
			edges = new LinkedList<Edge>();
		}

		public void addEdge(Edge e) {
			edges.addLast(e);
		}

		public int compareTo(Node node) {
			// two nodes are equal if they have the same label
			return node.info.compareTo(info);
		}

		public Comparable getLabel() {
			return info;
		}

		public void print() {
			System.out.println("Node label : " + info.toString());
			System.out.println("Edges :");
			for (int i = 0; i < this.edges.size(); i++) {
				Edge temp = (Edge) edges.get(i);
				temp.print();
			}
		}

		public String toString() {
			String s = "Node label : " + info.toString() + System.lineSeparator() + "Edges : " + System.lineSeparator();
			for (int i = 0; i < this.edges.size(); i++) {
				Edge temp = (Edge) edges.get(i);
				s += temp.toString() + System.lineSeparator();
			}
			return s;
		}

	}

	private class Edge implements Comparable<Edge> {
		private Node toNode;
		private Node fromNode;
		private int weight;
		private Comparable info;

		public Edge(Node from, Node to, int w, Comparable label) {
			fromNode = from;
			toNode = to;
			weight = w;
			info = label;
		}

		public int compareTo(Edge e) {
			return e.toNode.compareTo(toNode);
		}

		public Node getToNode() {
			return toNode;
		}

		public Comparable getLabel() {
			return info;
		}

		public Node getFromNode() {
			return fromNode;
		}

		public int getWeight() {
			return weight;
		}

		public void print() {
			System.out.println("An edge of weight " + this.weight + " that goes to the following node : "
					+ toNode.getLabel().toString());
		}

		public String toString() {
			String s = "An edge of weight " + this.weight + " that goes to the following node : "
					+ toNode.getLabel().toString();

			return s;
		}
	}

	private LinkedList<Node> nodes;
	private LinkedList<Edge> edges;

	public Graph() {
		nodes = new LinkedList<Node>();
		edges = new LinkedList<Edge>();
	}

	public void addNode(Comparable label) {
		nodes.addLast(new Node(label));
	}

	public LinkedList<Node> getNodes() {
		return nodes;
	}

	public Node findNode(Comparable nodeLabel) {
		return (Node) nodes.contains(new Node(nodeLabel));
	}

	public void addEdge(Comparable nodeLabel1, Comparable nodeLabel2, int w, Comparable label) {
		Node n1 = findNode(nodeLabel1);
		Node n2 = findNode(nodeLabel2);
		Edge edge = new Edge(n1, n2, w, label);
		n1.addEdge(edge);
		edges.addLast(edge);
	}

	public Comparable getEdgeLabel(Comparable nodeLabel1, Comparable nodeLabel2) {
		for (int i = 0; i < this.edges.size(); i++) {
			Edge tempEdge = this.edges.get(i);

			if (tempEdge.getFromNode().getLabel().compareTo(nodeLabel1) == 0
					&& tempEdge.getToNode().getLabel().compareTo(nodeLabel2) == 0) {
				return tempEdge.getLabel();
			}
		}
		return null;
	}

	public StackLl<String>[] getEdgePath(LinkedList<String>[] nodepaths) {

		StackLl<String>[] edgepaths = new StackLl[nodepaths.length];

		for (int i = 0; i < nodepaths.length; i++) {
			edgepaths[i] = new StackLl<String>();
			for (int j = nodepaths[i].size() - 1; j > 0; j--) {
				String edgelabel = (String) this.getEdgeLabel(nodepaths[i].get(j - 1), nodepaths[i].get(j));
				edgepaths[i].push(edgelabel);
			}
		}
		return edgepaths;
	}

	// Depth First Graph Traversal (topological sort)
	private void DFS(Node current, StackLl<Node> stack) {
		current.visited = true;
		for (int i = 0; i < current.edges.size(); i++) {
			Edge e = (Edge) current.edges.get(i);
			Node next = (Node) e.toNode;
			if (!next.visited) {
				DFS(next, stack);
			}
		}
		stack.push(current);
	}

	public void set_visited() {
		for (int i = 0; i < nodes.size(); i++) {
			Node current = (Node) nodes.get(i);
			current.visited = false;
		}
	}

	public void DFS(StackLl<Node> stack) {

		this.set_visited();

		for (int i = 0; i < nodes.size(); i++) {
			Node current = (Node) nodes.get(i);
			if (!current.visited) {
				DFS(current, stack);
			}
		}
	}

	// The returned path is incorrect at the moment...
	public LinkedList<Node> findPath(Comparable nodeLabel1, Comparable nodeLabel2) {

		this.set_visited();

		LinkedList<Node> path = new LinkedList<Node>();
		Node startState = findNode(nodeLabel1);
		Node endState = findNode(nodeLabel2);
		StackLl<Node> toDoList = new StackLl<Node>();
		toDoList.push(startState);
		while (!toDoList.empty()) {
			Node current = (Node) toDoList.pop();

			if (!current.visited) {
				path.addLast(current);
				current.visited = true;

				if (current.compareTo(endState) == 0) {
					return path;
				} else {
					for (int i = 0; i < current.edges.size(); i++) {
						Edge e = (Edge) current.edges.get(i);
						if (!e.getToNode().visited) {
							toDoList.push(e.toNode);
						}
					}
				}
			}
		}
		return new LinkedList<Node>();
	}

	// Shortest path algorithm for directed acyclic graphs (DAG) , runs in
	// linear time
	public LinkedList<String>[] shortestPathDag(String label) {

		// max integer number to do the relaxation
		int INF = Integer.MAX_VALUE;

		// Dictionary to map the nodes label to integers
		Dictionary<String, Integer> myDictionary = new Dictionary<String, Integer>();

		// Distances array
		int dist[] = new int[nodes.size()];

		// Paths array
		LinkedList<String>[] paths = new LinkedList[nodes.size()];

		// Call the recursive helper function to store the topological sort
		StackLl<Node> topoSort = new StackLl<Node>();
		this.DFS(topoSort);

		for (int i = 0; i < nodes.size(); i++) {

			// map nodes label to integers
			String node_label = (String) ((Node) nodes.get(i)).getLabel();
			myDictionary.add(node_label, i);

			// Initialize distances to all vertices as infinite
			dist[i] = INF;

			paths[i] = new LinkedList<String>();
		}
		// Initialize distance to source as 0
		int s = myDictionary.find(label);
		dist[s] = 0;

		// Process vertices in topological order
		while (topoSort.empty() == false) {

			// Get the next vertex from topological order
			Node node = topoSort.pop();
			int u = myDictionary.find((String) node.getLabel());

			// Update distances of all adjacent vertices
			if (dist[u] != INF) {
				for (int i = 0; i < node.edges.size(); i++) {

					String temp_label = (String) node.edges.get(i).getToNode().getLabel();
					int v = (int) myDictionary.find(temp_label);

					// relaxation
					if (dist[v] > dist[u] + node.edges.get(i).getWeight()) {

						// update distance
						dist[v] = dist[u] + node.edges.get(i).getWeight();

						// update path
						if (paths[u].size() > 0) {
							paths[v].addLast(paths[u].getFirst());
						}
						paths[v].addLast(temp_label);
					}
				}
			}
		}

		// // Print the calculated shortest distances
		// for (int i = 0; i < nodes.size(); i++) {
		// if (dist[i] == INF)
		// System.out.print("INF ");
		// else
		// System.out.print(dist[i] + " ");
		// }
		//
		for (int i = 0; i < nodes.size(); i++) {
			if (paths[i].size() == 0) {
				paths[i].addFirst(label);
			}
		}

		return paths;
	}

	// Bellman-Ford algorithm to find shortest path
	public LinkedList<String>[] shortestPath(String label) {

		// max integer number to do the relaxation
		int INF = Integer.MAX_VALUE;

		// Dictionary to map the nodes label to integers
		Dictionary<String, Integer> stringToIntNode = new Dictionary<String, Integer>();
		Dictionary<Integer, String> intToStringNode = new Dictionary<Integer, String>();

		// Distances array
		int dist[] = new int[nodes.size()];

		// predecessors array
		int[] predecessors = new int[nodes.size()];

		// Paths
		LinkedList<String>[] paths = new LinkedList[nodes.size()];

		for (int i = 0; i < nodes.size(); i++) {

			// map nodes label to integers
			String node_label = (String) ((Node) nodes.get(i)).getLabel();
			stringToIntNode.add(node_label, i);

			// map integers to nodes label
			intToStringNode.add(i, node_label);

			// Initialize distances to all vertices as infinite
			dist[i] = INF;

			// Initialize the paths
			paths[i] = new LinkedList<String>();

			predecessors[i] = 0;
		}
		// Initialize distance to source as 0
		int s = stringToIntNode.find(label);
		dist[s] = 0;

		for (int i = 0; i < this.nodes.size() - 1; i++) {
			for (int j = 0; j < this.edges.size(); j++) {

				String fromNodeLabel = (String) edges.get(j).getFromNode().getLabel();
				String toNodeLabel = (String) edges.get(j).getToNode().getLabel();

				int u = (int) stringToIntNode.find(fromNodeLabel);
				int v = (int) stringToIntNode.find(toNodeLabel);

				// relaxation
				if (dist[v] > dist[u] + edges.get(j).getWeight() && (dist[u] != INF)) {

					// update distance
					dist[v] = dist[u] + edges.get(j).getWeight();

					// update predecessor
					predecessors[v] = u;
				}
			}
		}

		// // Print the calculated shortest distances
		// for (int i = 0; i < nodes.size(); i++) {
		// if (dist[i] == INF)
		// System.out.print("INF ");
		// else
		// System.out.print(dist[i] + " ");
		// }

		// Traceback the shortest paths from each node to the source
		for (int i = 0; i < nodes.size(); i++) {
			int j = i;
			while (j != s) {
				String edge_label = intToStringNode.find(j);
				paths[i].addFirst(edge_label);
				j = predecessors[j];
			}
			paths[i].addFirst(label);
		}

		return paths;
	}

	public void print() {
		for (int i = 0; i < nodes.size(); i++) {
			((Node) nodes.get(i)).print();
			if (i != nodes.size() - 1) {
				System.out.println();
			}
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < nodes.size(); i++) {
			if (i != nodes.size() - 1) {
				s += nodes.get(i).toString() + System.lineSeparator();
			} else {
				s += nodes.get(i).toString();
			}
		}
		return s;
	}
}
