package dataStructuresGenerics;

public class Tree<T extends Comparable<T>> {

	// the class for implementing a node in the tree.
	// contains a value, a pointer to the left child,a pointer to the
	// right child and a pointer to the parent
	public class TreeNode<K extends Comparable<K>> implements Comparable<TreeNode<K>> {
		private K value;
		private TreeNode<K> leftNode;
		private TreeNode<K> rightNode;
		private TreeNode<K> parentNode;

		public TreeNode(K v) {
			value = v;
			leftNode = null;
			rightNode = null;
			parentNode = null;
		}

		public TreeNode(K v, TreeNode<K> left, TreeNode<K> right, TreeNode<K> parent) {
			value = v;
			leftNode = left;
			rightNode = right;
			parentNode = parent;
		}

		public TreeNode<K> getLeftTree() {
			return leftNode;
		}

		public TreeNode<K> getRightTree() {
			return rightNode;
		}

		public TreeNode<K> getParent() {
			return parentNode;
		}

		public K getValue() {
			return value;
		}

		public void setLeftTree(TreeNode<K> newleftNode) {
			leftNode = newleftNode;
		}

		public void setRightTree(TreeNode<K> newrightNode) {
			rightNode = newrightNode;
		}

		public void setParent(TreeNode<K> newParent) {
			parentNode = newParent;
		}

		public void setValue(K newValue) {
			value = newValue;
		}

		public int compareTo(TreeNode<K> node) {
			return this.value.compareTo(node.value);
		}

		public String toString() {
			return this.value.toString();
		}
	}

	public class TreePrinter extends TreeAction {
		public void run(TreeNode n) {
			System.out.println(n.getValue());
		}
	}

	// the root of our tree
	private TreeNode<T> root;
	private TreePrinter printer;
	private int count;

	public Tree() {
		root = null;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	// we traverse the tree.
	// Current holds the pointer to the TreeNode // we are currently checking
	// Parent holds the pointer to the parent
	// of the current TreeNode
	private void insertAtNode(T element, TreeNode<T> current, TreeNode<T> parent) {
		// if the node we check is empty
		if (current == null) {
			TreeNode<T> newNode = new TreeNode<T>(element);
			// the current node is empty, but we have a parent
			if (parent != null) {
				// do we add it to the left?
				if (element.compareTo(parent.value) < 0) {
					parent.setLeftTree(newNode);
				}
				// or do we add it to the right?
				else {
					parent.setRightTree(newNode);
				}
			}
			// the current node is empty and it has no parent,
			// we actually have an empty tree
			else {
				root = newNode;
			}
			newNode.setParent(parent);
			count++;
		} else if (element.compareTo(current.value) == 0) {
			// if the element is already in the tree, // what do we do?
			// at this point, we don’t care
		}
		// if the element is smaller than current, go left
		else if (element.compareTo(current.value) < 0) {
			insertAtNode(element, current.getLeftTree(), current);
		}
		// if the element is bigger than current, go right
		else {
			insertAtNode(element, current.getRightTree(), current);
		}
	}

	public void insert(T element) {
		insertAtNode(element, root, null);
	}

	private T findNode(T element, TreeNode<T> current) {
		if (current == null)
			return null;
		else if (element.compareTo(current.value) == 0)
			return current.value;
		else if (element.compareTo(current.value) < 0) {
			return findNode(element, current.getLeftTree());
		} else
			return findNode(element, current.getRightTree());
	}

	public T find(T element) {
		return findNode(element, root);
	}

	public void old_print() {

		TreePrinter printer = new TreePrinter();
		traverse_depth_first(printer);
	}

	public void print(boolean width) {
		if (width == true) {
			traverse_breadth_first(new TreeAction() {
				public void run(TreeNode n) {
					System.out.println(n.getValue());
				}
			});
		} else {
			traverse_depth_first(new TreeAction() {
				public void run(TreeNode n) {
					System.out.println(n.getValue());
				}
			});
		}
	}

	// public String toString() {
	//
	// traverse(new TreeAction() {
	// public void run(TreeNode n) {
	// n.getValue().toString()+"\n";
	// }
	// });
	// }

	public void traverse_breadth_first(TreeAction action) {
		QueueLl<TreeNode<T>> t = new QueueLl<TreeNode<T>>();
		t.push(root);
		while (!t.empty()) {
			TreeNode<T> n = t.pop();
			action.run(n);
			if (n.getLeftTree() != null) {
				t.push(n.getLeftTree());
			}
			if (n.getRightTree() != null) {
				t.push(n.getRightTree());
			}
		}
	}

	public void traverse_depth_first(TreeAction action) {
		StackLl<TreeNode<T>> t = new StackLl<TreeNode<T>>();
		t.push(root);
		while (!t.empty()) {
			TreeNode<T> n = t.pop();
			action.run(n);
			if (n.getLeftTree() != null) {
				t.push(n.getLeftTree());
			}
			if (n.getRightTree() != null) {
				t.push(n.getRightTree());
			}
		}
	}

	public TreeNode<T> minNode(TreeNode<T> current) {
		if (current == null)
			return null;
		else if (current.getLeftTree() == null)
			return current;
		else
			return minNode(current.getLeftTree());
	}

	private void transplant(TreeNode<T> oldNode, TreeNode<T> newNode) {
		if (oldNode.parentNode == null)
			root = newNode;
		else if (oldNode.parentNode.getLeftTree() == oldNode) {
			oldNode.parentNode.leftNode = newNode;
		} else
			oldNode.parentNode.rightNode = newNode;
		if (newNode != null)
			newNode.parentNode = oldNode.parentNode;
	}

	public void remove(T element) {
		removeNode(element, root);
	}

	private void removeNode(T element, TreeNode<T> current) {
		if (current == null)
			return;
		else if (element.compareTo(current.value) == 0) {
			if (current.leftNode == null) {
				transplant(current, current.getRightTree());
			} else if (current.rightNode == null) {
				transplant(current, current.getLeftTree());
			} else {
				TreeNode<T> y = minNode(current.getRightTree());
				if (y.getParent() != current) {
					transplant(y, y.rightNode);
					y.setRightTree(current.getRightTree());
					y.getRightTree().setParent(y);
				}
				transplant(current, y);
				y.setLeftTree(current.getLeftTree());
				y.getLeftTree().setParent(y);
				count--;
			}
		} else if (element.compareTo(current.value) < 0) {
			removeNode(element, current.getLeftTree());
		} else {
			removeNode(element, current.getRightTree());
		}
	}

	public int nodeDepth(TreeNode<T> node) {
		if (node == null) {
			return (0);
		} else {
			// compute the depth of each subtree
			int leftDepth = nodeDepth(node.getLeftTree());
			int rightDepth = nodeDepth(node.getRightTree());
			// use the larger one
			if (leftDepth > rightDepth)
				return (leftDepth + 1);
			else
				return (rightDepth + 1);
		}
	}

	public int maxDepth() {
		return nodeDepth(root);
	}

	public T find_biggest() {
		TreeNode<T> biggest = root;
		TreeNode<T> rightTree = root.getRightTree();

		if (rightTree != null) {
			while (rightTree != null) {
				biggest = rightTree;
				rightTree = rightTree.getRightTree();
			}
		}
		return biggest.getValue();
	}

	public void remove_biggest() {
		TreeNode<T> parent = root;
		TreeNode<T> rightTree = root.getRightTree();

		if (rightTree != null) {
			while (rightTree.getRightTree() != null) {
				parent = rightTree;
				rightTree = rightTree.getRightTree();
			}
			parent.setRightTree(rightTree.getLeftTree());
		} else {
			root = null;
		}
		count--;
	}

	public void swapTreeNode(TreeNode<T> node) {

		TreeNode<T> rightTempTree = node.getRightTree();
		TreeNode<T> leftTempTree = node.getLeftTree();

		node.setLeftTree(rightTempTree);
		node.setRightTree(leftTempTree);

		if (rightTempTree != null) {
			swapTreeNode(rightTempTree);
		}

		if (leftTempTree != null) {
			swapTreeNode(leftTempTree);
		}
	}

	public void swapTree() {
		swapTreeNode(root);
	}

}
