package src.main.java.com.saurav.dsa.tree;

public class RedBlackTree {

	public static void main(String[] args) {
		RBT tree = new RBT();
		tree.insert(1);
		tree.insert(4);
		tree.insert(6);
		tree.insert(3);
		tree.insert(5);
		tree.insert(7);
		tree.insert(8);
		tree.insert(2);
		tree.insert(9);

		tree.insert(6); // duplicate
		tree.insert(4); // duplicate
		tree.insert(1); // duplicate
		tree.display();

		// Negative scenario
		tree.delete(0);
		tree.delete(-1);

		// No child scenario
		tree.insert(10);
		tree.display();

		tree.delete(10);
		tree.display();

		// One child scenario
		tree.insert(10);
		tree.display();

		tree.delete(9);
		tree.display();

		// two child scenario
		tree.delete(2);
		tree.display();

		// delete red parent
		tree.delete(4);
		tree.display();

		// delete black child
		tree.delete(5);
		tree.display();

		// double black scenario
		tree.insert(5);
		tree.insert(2);
		tree.insert(9);
		tree.insert(4);
		tree.insert(11);
		tree.insert(12);
		tree.insert(13);
		tree.insert(14);
		tree.insert(15);
		tree.insert(16);
		tree.insert(17);
		tree.insert(18);
		tree.insert(19);
		tree.insert(20);
		tree.insert(21);
		tree.insert(22);
		tree.insert(23);
		tree.insert(24);
		tree.display();

		tree.delete(20);

		tree.display();
	}
}

class RBT {
	class Node {
		int data;
		Node left, right, parent;
		boolean isRed;

		public Node(int data) {
			this.data = data;
			isRed = true;
		}
	}

	private final Node NIL = new Node(-1);
	private Node root;

	public RBT() {
		NIL.isRed = false;
		NIL.left = NIL;
		NIL.right = NIL;
		NIL.parent = NIL;
		root = NIL;
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		newNode.left = NIL;
		newNode.right = NIL;

		Node curr = root;
		Node prev = NIL;

		while (curr != NIL) {
			prev = curr;
			if (curr.data == data) {
				System.out.println(data + " already present.");
				return;
			} else if (curr.data > data) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}

		if (prev == NIL) {
			root = newNode;
		} else if (data < prev.data) {
			prev.left = newNode;
		} else {
			prev.right = newNode;
		}
		newNode.parent = prev;
		fixInsert(newNode);
		System.out.println(data+" added to the tree.");
		
	}

	private void fixInsert(Node node) {
		while (node.parent.isRed) {
			if (node.parent == node.parent.parent.left) {
				Node uncle = node.parent.parent.right;
				if (uncle.isRed) {
					node.parent.isRed = false;
					uncle.isRed = false;
					node.parent.parent.isRed = true;
					node = node.parent.parent;
				} else {
					if (node == node.parent.right) {
						node = node.parent;
						leftRotate(node);
					}
					node.parent.isRed = false;
					node.parent.parent.isRed = true;
					rightRotate(node.parent.parent);
				}
			} else {
				Node uncle = node.parent.parent.left;
				if (uncle.isRed) {
					node.parent.isRed = false;
					uncle.isRed = false;
					node.parent.parent.isRed = true;
					node = node.parent.parent;
				} else {
					if (node == node.parent.left) {
						node = node.parent;
						rightRotate(node);
					}
					node.parent.isRed = false;
					node.parent.parent.isRed = true;
					leftRotate(node.parent.parent);
				}
			}
		}
		root.isRed = false;
	}

	private void leftRotate(Node node) {
		Node x = node.right;

		node.right = x.left;

		if (x.left != NIL) {
			x.left.parent = node;
		}

		transplant(node, x);

		node.parent = x;
		x.left = node;
	}

	private void rightRotate(Node node) {
		Node x = node.left;

		node.left = x.right;

		if (x.right != NIL) {
			x.right.parent = node;
		}
		transplant(node, x);

		node.parent = x;
		x.right = node;
	}

	public void delete(int data) {
		Node node = root;
		while (node != NIL && node.data != data) {
			if (node.data > data) {
				node = node.left;
			} else {
				node = node.right;
			}
		}

		if (node == NIL) {
			System.out.println(data + " not present in the tree.");
			return;
		}

		Node y = node; // Node that will be deleted
		boolean yOriginalColor = y.isRed;
		Node x; // Node that will replace y
		if (node.left == NIL) {
			x = node.right;
			transplant(node, node.right);
		} else if (node.right == NIL) {
			x = node.left;
			transplant(node, node.left);
		} else {
			y = findMin(node.right);
			yOriginalColor = y.isRed;
			x = y.right;

			if (y.parent == node) {
				x.parent = y; // x's parent should be y even if x is NIL
			} else {
				transplant(y, y.right);
				y.right = node.right;
				y.right.parent = y;
			}
			transplant(node, y);
			y.left = node.left;
			y.left.parent = y;
			y.isRed = node.isRed;
		}

		if (!yOriginalColor) {
			fixDelete(x);
		}
		System.out.println(data+" deleted from the tree.");
	}

	private void fixDelete(Node node) {
		while (node != root && !node.isRed) {
			if (node == node.parent.left) {
				Node sibling = node.parent.right;
				// Case 1 : sibling is Red
				if (sibling.isRed) {
					sibling.isRed = false;
					node.parent.isRed = true;
					leftRotate(node.parent);
					sibling = node.parent.right;
				}
				// sibling will be black (either initially or after case 1)
				// Case 2 : Sibling's both the children are black
				if (!sibling.left.isRed && !sibling.right.isRed) {
					sibling.isRed = true;
					node = node.parent;
				} else {
					// Case 3 : Sibling's Right child is black
					if (!sibling.right.isRed) {
						sibling.left.isRed = false;
						sibling.isRed = true;
						rightRotate(sibling);
						sibling = node.parent.right;
					}
					// Sibling's Right child is red ( either initially or after case 3)
					// Case 4 : Sibling's is black and sibling's right child is red
					sibling.isRed = node.parent.isRed;
					node.parent.isRed = false;
					sibling.right.isRed = false;
					leftRotate(node.parent);
					node = root;
				}
			} else {
				Node sibling = node.parent.left;
				// Case 1 : sibling is Red
				if (sibling.isRed) {
					sibling.isRed = false;
					node.parent.isRed = true;
					rightRotate(node.parent);
					sibling = node.parent.left;
				}
				// sibling will be black (either initially or after case 1)
				// Case 2 : Sibling's both the children are black
				if (!sibling.left.isRed && !sibling.right.isRed) {
					sibling.isRed = true;
					node = node.parent;
				} else {
					// Case 3 : Sibling's left child is black
					if (!sibling.left.isRed) {
						sibling.right.isRed = false;
						sibling.isRed = true;
						leftRotate(sibling);
						sibling = node.parent.left;
					}
					// Sibling's left child is red ( either initially or after case 3)
					// Case 4 : Sibling's is black and sibling's left child is red
					sibling.isRed = node.parent.isRed;
					node.parent.isRed = false;
					sibling.left.isRed = false;
					rightRotate(node.parent);
					node = root;
				}
			}
		}
		node.isRed = false;
	}

	// Transplant n1's parent to n2
	private void transplant(Node n1, Node n2) {
		if (n1 == root) {
			root = n2;
		} else if (n1 == n1.parent.left) {
			n1.parent.left = n2;
		} else {
			n1.parent.right = n2;
		}
		n2.parent = n1.parent;
	}

	private Node findMin(Node node) {
		while (node.left != NIL) {
			node = node.left;
		}
		return node;
	}

	public void display() {
		prettyPrint(root, 0);
		System.out.println("==============================================");
	}

	private void prettyPrint(Node node, int lvl) {
		if (node != NIL) {
			prettyPrint(node.right, lvl + 1);
			System.out.println("	".repeat(lvl) + "(" + node.data + ", " + (node.isRed ? "R" : "B") + ")");
			prettyPrint(node.left, lvl + 1);
		}
	}
}