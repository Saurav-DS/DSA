
public class Stack {

	public static void main(String[] args) {
		
		List stack = new List(5);
		
		stack.peek();
		stack.getStackSize();
		stack.getCurrentSize();
		stack.push(0);
		stack.push(4);
		stack.push(2);
		stack.push(1);
		stack.push(99);
		stack.push(88);
		stack.getStackSize();
		stack.getCurrentSize();
		stack.peek();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.getStackSize();
		stack.getCurrentSize();
		
	}
}
/*
 * Stack [FILO]
 * 
 * All the operations performed on the Stack are in constant time O(1)
 * 
 * The @return of all the methods are void.
 * 
 * push()		: @param int val to be added at the head of Stack. 
 * 			: Adds the element at the head of Stack.
 * pop()		: Removes the element from the head of Stack.
 * peek()		: Displays the element present at the head of Stack.
 * getStackSize() 	: Displays the max size of Stack.
 * getCurrentSize()	: Displays the current size of Stack.
 * 
 */
class List{
	class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	private Node head=null;
	private int maxSize;
	private int size=-1;
	
	public List(int size) {
		this.maxSize = (size-1);
	}
	
	public void push(int val) {
		if(head==null && size<maxSize) {
			head = new Node(val);
			size++;
			System.out.println(val+" added to the head of Stack.");
		}
		else if(head!=null && size<maxSize){
			Node node = new Node(val);
			node.next = head;
			head = node;
			size++;
			System.out.println(val+" added to the head of Stack.");
		}
		else{
			System.out.println("Stack Overflow : Stack is full.");
		}
	}
	public void pop() {
		if(head!=null && size>-1) {
			System.out.println(head.data+" removed from the head of Stack.");
			head = head.next;
			size--;
		}
		else {
			System.out.println("Stack is empty : No element present in Stack.");
		}
	}
	public void peek() {
		if(head!=null && size>-1) {
			System.out.println("Element at head : "+head.data);
		}
		if(size==-1) {
			System.out.println("Stack is empty : No element present in Stack.");
		}
	}
	public void getStackSize() {
		System.out.println("Max size of array is "+(this.maxSize+1));
	}
	public void getCurrentSize() {
		System.out.println("Current size of array is "+(this.size+1));
	}
}
