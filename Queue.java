
public class Queue {

	public static void main(String[] args) {
		QueueList queue = new QueueList();
		
		queue.size();
		queue.peek();
		queue.add(5);
		queue.add(8);
		queue.add(1);
		queue.add(9);
		queue.add(2);
		queue.size();
		queue.peek();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.peek();
		queue.remove();
		queue.remove();
		queue.size();
		queue.peek();
	}
	/*
	 * Queue [FIFO]
	 * 
	 * All the operations performed on the Queue are in constant time O(1)
	 * 
	 * The @return of all the methods are void.
	 * 
	 * add()	: @param int val to be added at the tail of Queue. 
	 * remove()	: Removes the element from the head of Queue.
	 * peek()	: Displays the element present at the head of Queue.
	 * size()	: Displays the current size of Queue.
	 * 
	 */
}
class QueueList{
	class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
		}
	}
	private Node head;
	private Node tail;
	private int size=0;
	
	public void add(int data) {
		if(head==null) {
			head = new Node(data);
			tail=head;
			size++;
		}
		else {
			Node node = new Node(data);
			tail.next = node;
			tail = node;
			size++;
		}
		System.out.println(data+" added to the Queue.");
	}
	public void remove() {
		if(head!=null) {
			System.out.println(head.data+" removed from Queue.");
			head=head.next;
			size--;
		}
		else {
			System.out.println("Queue is empty, No element available to remove.");
		}
	}
	public void peek() {
		if(head!=null) {
			System.out.println(head.data+" present at the head of Queue.");
		}
		else {
			System.out.println("Queue is empty, No element present in Queue.");
		}
	}
	public void size() {
		System.out.println("Current size of Queue is "+this.size);
	}
}
