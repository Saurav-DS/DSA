
public class DoublyLinkedList {

	public static void main(String[] args) {
		// Initialization of linked list
		DoubleEndedList list = new DoubleEndedList();
		System.out.println("Initial size of linked list : " + list.size);
		list.displayFromHead();
		list.displayFromTail();
		
		list.addAtHead(5);
		list.addAtHead(4);
		list.addAtHead(9);
		list.addAtHead(2);
		list.addAtHead(7);
		list.displayFromHead();
		System.out.println("Size after adding few elements at the head : " + list.size);
		
		list.addAtTail(0);
		list.addAtTail(11);
		list.displayFromHead();
		System.out.println("Size after adding few elements at the head and tail : " + list.size);
		
		list.deleteByValue(5);// Middle scenario
		list.deleteByValue(7);// Extreme Left scenario
		list.deleteByValue(11);// Extreme Right scenario
		list.deleteByValue(1);// Negative scenario
		
		list.displayFromHead();
		
		list.deleteFromHead();
		list.deleteFromHead();
		list.deleteFromHead();
		System.out.println("Size after deleting 4 elements : " + list.size);
		
		list.deleteFromTail();
		list.deleteFromTail();
		list.deleteFromTail();
		
		list.displayFromHead();
		list.displayFromTail();
		System.out.println("Size after deleting all Elements : " + list.size);
	}

}

/*
 * Doubly Linked List Definition Class
 * 
 * size 			 : to display the current size of linked list. 
 * isEmpty() 		 : returns boolean object true/false. 
 * head() 			 : displays the element present at the head of linked list. 
 * tail() 			 : displays the element present at the tail of linked list. 
 * displayFromHead() : displays all the elements of linked list starting from head. 
 * displayFromTail() : displays all the elements of linked list starting from tail. 
 * addAtHead() 		 : takes int value to be added at the head of linked list. 
 * addAtTail() 		 : takes int value to be added at the tail of linked list. 
 * deleteFromHead()  : deletes the value present at head and updates the head position. 
 * deleteFromTail()  : deletes the value present at tail and updates the tail position. 
 * deleteByValue()   : takes int value and delete the first occurrence of that value from the linked list if present.
 * 
 */
class DoubleEndedList {
	class Node {
		Node previous;
		int value;
		Node next;

		public Node(int value) {
			super();
			this.value = value;
		}

	}

	Node head;
	Node tail;
	int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public void head() {
		System.out.println((head != null) ? head.value : "Linked list is empty.");
	}

	public void tail() {
		System.out.println((tail != null) ? tail.value : "Linked list is empty.");
	}

	public void displayFromHead() {
		Node node = head;
		if (node == null) {
			System.out.println("Linked list is empty.");
			return;
		}
		while (node != null) {
			System.out.print(node.value);
			node = node.next;
			if (node != null) {
				System.out.print(" <-> ");
			}
		}
		System.out.println();
	}

	public void displayFromTail() {
		Node node = tail;
		if (node == null) {
			System.out.println("Linked list is empty.");
			return;
		}
		while (node != null) {
			System.out.print(node.value);
			node = node.previous;
			if (node != null) {
				System.out.print(" <-> ");
			}
		}
		System.out.println();
	}

	public void addAtHead(int v) {
		if (head != null) {
			Node node = new Node(v);
			node.next = head;
			head.previous = node;
			head = node;
		} else {
			head = new Node(v);
			tail = head;
		}
		size++;
	}

	public void addAtTail(int v) {
		if (tail != null) {
			Node node = new Node(v);
			node.previous = tail;
			tail.next = node;
			tail = node;
		} else {
			head = new Node(v);
			tail = head;
		}
		size++;
	}

	public void deleteFromHead() {
		if (head != null) {
			System.out.println(head.value + " is deleted from the head of linked list.");
			Node node = head.next;
			if (node != null) {
				node.previous = null;
			} else {
				tail = null;
			}
			head = node;
			size--;
		} else {
			System.out.println("Linked list is empty.");
		}
	}

	public void deleteFromTail() {
		if (tail != null) {
			System.out.println(tail.value + " is deleted from the tail of linked list.");
			Node node = tail.previous;
			if (node != null) {
				node.next = null;
			} else {
				head = null;
			}
			tail = node;
			size--;
		} else {
			System.out.println("Linked list is empty.");
		}
	}

	public void deleteByValue(int val) {
		Node node = head;
		if (node == null) {
			System.out.println("Linked list is empty.");
			return;
		}
		if (node.value == val) {
			deleteFromHead();
			return;
		}
		while (node.next != null && node.next != tail) {
			node = node.next;
			if (node.value == val) {
				Node pre = node.previous;
				Node nxt = node.next;

				pre.next = nxt;
				nxt.previous = pre;

				System.out.println(val + " is deleted from the linked list.");
				size--;
				return;
			}
		}
		if (tail.value == val) {
			deleteFromTail();
			return;
		}
		System.out.println(val + " is not present in linked list.");
	}
}
