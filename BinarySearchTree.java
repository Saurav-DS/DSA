import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BinarySearchTree {

	public static void main(String[] args) {
		Tree<Integer> bst = new Tree<Integer>();

		bst.display(); // Display on empty Tree
		bst.add(6);
		bst.add(3);
		bst.display(); // Display after adding 2 Elements to the Tree
		bst.remove(6); // Removing the root node
		bst.display(); 
		bst.remove(3); // Removing all the elements from the Tree
		bst.display();
		bst.remove(11); // Attempting Remove on empty Tree
		
		bst.add(6);
		bst.add(3);
		bst.add(8);
		bst.add(1);
		bst.add(2);
		bst.add(5);
		bst.add(4);
		bst.add(7);
		bst.add(9);
		bst.add(10);
		bst.add(0);
		bst.display(); // Displaying all the elements in pre-order, in-order & post-order (Depth first search algos)

		bst.find(5); // Positive find scenario
		bst.find(10); // Positive max scenario
		bst.find(0); // positive min scenario
		bst.find(-1); // negative min scenario
		bst.find(11); // negative max scenario

		bst.remove(10); // Type 1(Leaf element) remove
		bst.display(); 
		bst.remove(5); // Type 2(Edge with 1 child) remove
		bst.display();
		bst.remove(6); // Type 3(Edge with 2 children) remove
		bst.display();
		bst.remove(55); // Negative remove Scenario
		bst.remove(10); // Negative remove Scenario
		
		
		System.out.print("Breadth-First Search : ");
		bst.breadthFirst(); // Breadth first Search
	}
}
/*
 * Binary Search Tree Class
 * 
 * isEmpty() 		 				: returns boolean object true/false. 
 * add(T data)		 				: Adds the element to the tree in ascending order. 
 * find(T data)		 				: returns boolean true/false, checks if the element present in the tree.
 * findSmallestValue() 				: returns the smallest value present in the tree. 
 * findLargestValue() 				: returns the largest value present in the tree. 
 * remove(T data)	 				: removes the given element from the tree.
 * display() 		 				: displays the element of the tree in pre-order, in-order & post-order (Depth-first search) 
 * inOrderTraverse(Node<T> node)	: traverse all the elements of the tree and displays in in-order.
 * preOrderTraverse(Node<T> node)	: traverse all the elements of the tree and displays in pre-order.
 * postOrderTraverse(Node<T> node) 	: traverse all the elements of the tree and displays in post-order.
 * breadthFirst()   				: traverse all the elements of 1 level before going to next level and displays in breadth-first search order.
 * 
 */

class Tree<T extends Comparable<T>> {

	class Node<T> {
		private T data;
		private Node<T> left, right;

		public Node(T data) {
			System.out.println(data + " added to the tree.");
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			System.out.println(this.data + " is updated to " + data);
			this.data = data;
		}

		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}

	}

	Node<T> root;
	
	public boolean isEmpty() {return root==null;}

	public void add(T data) {
		root = add(root, data);
	}

	private Node<T> add(Node<T> node, T data) {
		if (node == null) {
			node = new Node<T>(data);
		} else if (node.getData().compareTo(data) > 0) {
			node.setLeft(add(node.getLeft(), data));
		} else if (node.getData().compareTo(data) < 0) {
			node.setRight(add(node.getRight(), data));
		}

		return node;
	}

	public boolean find(T data) {
		Node<T> node = find(root, data);
		System.out.println((node == null) ? data + " not present in the Tree." : data + " is present in the Tree.");
		return (node == null) ? false : true;
	}

	private Node<T> find(Node<T> node, T data) {
		if (node == null) {
			return null;
		}
		if (node.getData().compareTo(data) == 0) {
			return node;
		}
		return (node.getData().compareTo(data) > 0) ? find(node.getLeft(), data) : find(node.getRight(), data);
	}
	
	public T findSmallestValue() {
		return findSmallestValue(root);
	}

	private T findSmallestValue(Node<T> node) {
		return (node.getLeft() == null) ? node.getData() : findSmallestValue(node.getLeft());
	}
	public T findLargestValue() {
		return findLargestValue(root);
	}

	private T findLargestValue(Node<T> node) {
		return (node.getRight() == null) ? node.getData() : findLargestValue(node.getRight());
	}

	public void remove(T data) {
		root = remove(root, data);
	}

	public Node<T> remove(Node<T> current, T data) {

		if (current == null) {
			System.out.println(data + " not present in the tree.");
			return null;
		}

		else if (current.getData().compareTo(data) > 0) {
			current.setLeft(remove(current.getLeft(), data));
		}

		else if (current.getData().compareTo(data) < 0) {
			current.setRight(remove(current.getRight(), data));
		}

		else {

			if (current.getLeft() == null && current.getRight() == null) {
				System.out.println(data + " removed from the tree.");
				return null;
			}

			else if (current.getRight() == null) {
				System.out.println(data + " removed from the tree.");
				return current.getLeft();
			}

			else if (current.getLeft() == null) {
				System.out.println(data + " removed from the tree.");
				return current.getRight();
			}

			else {
				current.setData(findSmallestValue(current.getRight()));
				current.setRight(remove(current.getRight(), current.getData()));
			}
		}

		return current;
	}

	public void display() {
		if (root != null) {
			System.out.print("In-order Traversing:   ");
			inOrderTraverse(root);
			System.out.println();
			System.out.print("pre-order Traversing:  ");
			preOrderTraverse(root);
			System.out.println();
			System.out.print("post-order Traversing: ");
			postOrderTraverse(root);
			System.out.println();
		} else {
			System.out.println("Tree is empty.");
		}
	}

	public void inOrderTraverse(Node<T> node) {
		if (node != null) {
			inOrderTraverse(node.getLeft());
			System.out.print(node.getData() + " ");
			inOrderTraverse(node.getRight());
		}
	}

	public void preOrderTraverse(Node<T> node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			preOrderTraverse(node.getLeft());
			preOrderTraverse(node.getRight());
		}
	}

	public void postOrderTraverse(Node<T> node) {
		if (node != null) {
			postOrderTraverse(node.getLeft());
			postOrderTraverse(node.getRight());
			System.out.print(node.getData() + " ");
		}
	}
	
	public void breadthFirst() {
		Queue<Node<T>> queue = new ConcurrentLinkedQueue<Node<T>>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node<T> node = queue.remove();
			System.out.print(node.getData()+" ");
			if(node.getLeft()!=null) {
				queue.add(node.getLeft());
			}
			if(node.getRight()!=null) {
				queue.add(node.getRight());
			}
		}
		
	}

}
