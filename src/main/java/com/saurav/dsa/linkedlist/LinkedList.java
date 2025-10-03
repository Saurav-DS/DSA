package src.main.java.com.saurav.dsa.linkedlist;

public class LinkedList {

	public static void main(String[] args) {
		// Initialization of linked list
		LL list = new LL();
		// display method call to see the content of the linked list
		list.display();
		// addNode method call to add the nodes at the head of linked list
		list.addNode(5);
		list.addNode(4);
		list.addNode(9);
		list.addNode(2);
		list.addNode(7);
		// display method call to see the content of the linked list
		list.display();
		// deleteNode method call to delete the nodes from the head of linked list
		list.deleteNode();
		list.deleteNode();
		list.deleteNode();
		list.deleteNode();
		list.deleteNode();
		list.deleteNode();
	}

}

/*
 * Linked List Definition Class
 */
class LL {
	/*
	 * Node Definition Class
	 */
	class Node {
		int value;
		Node next;

		public Node(int value) {
			super();
			this.value = value;
		}

	}

	Node head;

	/*
	 * This method prints all the elements of the linked list.
	 * Time complexity O(N)
	 * Space complexity O(1)
	 * 
	 * @param none
	 * 
	 * @return void
	 */
	public void display() {
		Node node = head;
		if (node == null) {
			System.out.println("Linked list is empty.");
			return;
		}
		while (node != null) {
			System.out.print(node.value);
			node = node.next;
			if (node != null) {
				System.out.print(" -> ");
			}
		}
		System.out.println();
	}

	/*
	 * This method adds a node on the head of linked list.
	 * Time complexity O(1)
	 * Space complexity O(1)
	 * 
	 * @param v value of the node
	 * 
	 * @return void
	 */
	public void addNode(int v) {
		if (head != null) {
			Node node = new Node(v);
			node.next = head;
			head = node;
		} else {
			head = new Node(v);
		}
	}

	/*
	 * This method deletes a node from the head of linked list.
	 * Time Complexity O(1)
	 * Space Complexity O(1)
	 * 
	 * @param none
	 * 
	 * @return void
	 */
	public void deleteNode() {
		if (head != null) {
			System.out.println(head.value + " is deleted from the linked list.");
			head = head.next;
		} else {
			System.out.println("Linked list is empty.");
		}
	}

}
