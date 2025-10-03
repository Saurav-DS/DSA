package src.main.java.com.saurav.dsa.queue;

public class Deque {

	public static void main(String[] args) {
		DequeList deque = new DequeList();
		
		deque.size();
		deque.addAtHead(5);
		deque.addAtHead(2);
		deque.size();
		deque.addAtTail(7);
		deque.addAtTail(9);
		deque.size();
		deque.removeFromHead();
		deque.removeFromTail();
		deque.size();
		deque.removeFromHead();
		deque.removeFromTail();
		deque.size();
		deque.removeFromHead();
		deque.removeFromTail();
		deque.size();
	}

}
/*
 * Deque (Double Ended Queue)
 * 
 * All the operations performed on the Stack are in constant time O(1)
 * 
 * The @return of all the methods are void.
 * 
 * addAtHead()		: @param int val to be added at the head of Deque. 
 * removeFromHead()	: Removes the element from the head of Deque.
 * addAtTail()		: @param int val to be added at the tail of Deque. 
 * removeFromTail()	: Removes the element from the tail of Deque.
 * size()			: Displays the current size of Queue.
 * 
 */

class DequeList {
	class Node {
		int data;
		Node next;
		Node previous;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node head;
	private Node tail;
	private int size = 0;

	public void addAtHead(int data) {
		if (head == null) {
			head = new Node(data);
			tail = head;
			size++;
		} else {
			Node node = new Node(data);
			node.next = head;
			head.previous = node;
			head = node;
			size++;
		}
		System.out.println(data+" is added at the head of Deque.");
	}

	public void addAtTail(int data) {
		if (head == null) {
			head = new Node(data);
			tail = head;
			size++;
		} else {
			Node node = new Node(data);
			tail.next = node;
			node.previous = tail;
			tail = node;
			size++;
		}
		System.out.println(data+" is added at the tail of Deque.");
	}

	public void removeFromHead() {
		if (head != null) {
			System.out.println(head.data+" is removed from the head of Deque.");
			head = head.next;
			if(head!=null) {
				head.previous = null;
			}
			else {
				tail=null;
			}
			size--;
		} else {
			System.out.println("Deque is empty.");
		}
	}

	public void removeFromTail() {
		if (tail != null) {
			System.out.println(tail.data+" is removed from the tail of Deque.");
			tail = tail.previous;
			if(tail!=null) {
				tail.next = null;
			}
			else {
				head=null;
			}
			size--;
		} else {
			System.out.println("Deque is empty.");
		}
	}
	public void size() {
		System.out.println("Size of Deque is "+this.size);
	}
}
