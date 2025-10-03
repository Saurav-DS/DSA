package src.main.java.com.saurav.dsa.tree;

public class AVLTree {

	public static void main(String[] args) {
		AVL tree = new AVL();
		tree.insert(6);
		tree.insert(2);
		tree.insert(10);
		tree.insert(4);
		tree.insert(3);
		tree.insert(0);
		tree.insert(1);
		tree.insert(-1);
		tree.insert(8);
		tree.insert(9);
		tree.insert(7);
		tree.insert(5);
		tree.insert(12);
		tree.insert(11);
		tree.insert(13);
		tree.insert(6);
		tree.insert(0);
		tree.insert(11);
		tree.display();

		// Delete without disturbing balance factor
		tree.delete(5);
		tree.display();

		// Deleting with disturbed balance factor
		tree.insert(5);
		tree.display();
		tree.delete(7);
		tree.display();

		// Deleting with single child disturbing balance factor
		tree.delete(0);
		tree.display();
		
		tree.delete(8);
		tree.display();
	}
}

class AVL {
	static class Node {
		int data;
		Node left, right;
		int height;

		Node(int data) {
			this.data = data;
			this.height = 0;
		}
	}

	Node root;

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, int data) {
		if (node == null) {
			return new Node(data);
		}

		if (node.data > data) {
			node.left = insert(node.left, data);
		} else if (node.data < data) {
			node.right = insert(node.right, data);
		} else {
			System.out.println("Duplicate value " + data + " not inserted.");
			return node;
		}
		// Update height
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

		// Get balance factor
		int balance = getBalance(node);

		// Case 1 : Left left
		if (balance > 1 && getBalance(node.left) >= 0) {
			System.out.println("Right Rotation on " + node.data);
			return rightRotate(node);
		}

		// Case 2 : Left right
		if (balance > 1 && getBalance(node.left) < 0) {
			System.out.println("Left Rotation on " + node.left.data);
			node.left = leftRotate(node.left);
			System.out.println("Right Rotation on " + node.data);
			return rightRotate(node);
		}

		// Case 3 : Right right
		if (balance < -1 && getBalance(node.right) <= 0) {
			System.out.println("Left Rotation on " + node.data);
			return leftRotate(node);
		}

		// Case 4 : Right left
		if (balance < -1 && getBalance(node.right) > 0) {
			System.out.println("Right Rotation on " + node.right.data);
			node.right = rightRotate(node.right);
			System.out.println("Left Rotation on " + node.data);
			return leftRotate(node);
		}

		return node;
	}

	private Node leftRotate(Node x) {
		Node y = x.right;
		Node t2 = y.left;

		x.right = t2;
		y.left = x;

		// Update height
		x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
		y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

		return y;
	}

	private Node rightRotate(Node x) {
		Node y = x.left;
		Node t2 = y.right;

		x.left = t2;
		y.right = x;

		// Update height
		x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
		y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

		return y;
	}

	private int getHeight(Node node) {
		return (node == null) ? -1 : node.height;
	}

	private int getBalance(Node node) {
		if (node == null)
			return 0;
		return getHeight(node.left) - getHeight(node.right);
	}

	public void display() {
		prettyPrint(root, 0);
		System.out.println("===========================================================");
	}

	private void prettyPrint(Node node, int level) {
		if (node != null) {
			prettyPrint(node.right, level + 1);
			System.out.println("	".repeat(level) + " (" + node.data + ", " + node.height + ")");
			prettyPrint(node.left, level + 1);
		}
	}

	public void delete(int data) {
		root = delete(root, data);
	}

	public Node delete(Node node, int data) {

		if (node == null)
			return null;

		if (node.data > data) {
			node.left = delete(node.left, data);
		} else if (node.data < data) {
			node.right = delete(node.right, data);
		} else {
			// Case 1 & 2 | 1 Child or No Child
			if (node.left == null) {
				node = node.right;
			} else if (node.right == null) {
				node = node.left;
			}
			// Case 3 | 2 Child
			else {
				int min = findMin(node.right);
				node.data = min;
				node.right = delete(node.right, min);
			}
		}
		// If Node was leaf node return
		if (node == null) {
			return null;
		}
		// Update height
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

		// Calculate Balance Factor
		int balance = getBalance(node);

		// Case 1 : Left left
		if (balance > 1 && getBalance(node.left) >= 0) {
			System.out.println("Right Rotation on " + node.data);
			return rightRotate(node);
		}

		// Case 2 : Left right
		if (balance > 1 && getBalance(node.left) < 0) {
			System.out.println("Left Rotation on " + node.left.data);
			node.left = leftRotate(node.left);
			System.out.println("Right Rotation on " + node.data);
			return rightRotate(node);
		}

		// Case 3 : Right right
		if (balance < -1 && getBalance(node.right) <= 0) {
			System.out.println("Left Rotation on " + node.data);
			return leftRotate(node);
		}

		// Case 4 : Right left
		if (balance < -1 && getBalance(node.right) > 0) {
			System.out.println("Right Rotation on " + node.right.data);
			node.right = rightRotate(node.right);
			System.out.println("Left Rotation on " + node.data);
			return leftRotate(node);
		}

		return node;
	}

	private int findMin(Node node) {
		if (node == null) {
			throw new IllegalArgumentException("Subtree is null");
		}
		while (node.left != null) {
			node = node.left;
		}
		return node.data;
	}
}
