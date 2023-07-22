
public class BinaryHeap {

	public static void main(String[] args) {
		
		minHeap heap = new minHeap(10);
		
		heap.display();
		
		heap.extractMin();
		
		heap.insertNode(5);
		
		heap.display();
		
		heap.insertNode(5);
		heap.insertNode(5);
		heap.display();
		
		heap.extractMin();
		
		heap.extractMin();
		
		heap.display();
		
		heap.extractMin();
		heap.extractMin();
		
		heap.insertNode(3);
		
		heap.display();
		
		heap.extractMin();
		heap.extractMin();
		heap.extractMin();
		
		heap.display();

		heap.insertNode(7);
		heap.insertNode(4);
		heap.insertNode(9);
		heap.insertNode(1);
		
		heap.display();
		
		System.out.println("The maximum capacity of heap is "+heap.maxSize()+" ; The current size of heap is "+heap.currentSize());
		
		heap.insertNode(2);
		heap.insertNode(6);
		heap.insertNode(0);
		heap.insertNode(8);
		heap.insertNode(10);
		heap.insertNode(5);
		heap.insertNode(3);
		
		heap.display();
		
		System.out.println("The maximum capacity of heap is "+heap.maxSize()+" ; The current size of heap is "+heap.currentSize());
		
		heap.extractMin();
		heap.extractMin();
		
		System.out.println(heap.getMin()+" is the min element of the heap.");
		
		heap.display();
		
	}

}
/*
 * Binary Search Tree Class
 * 
 * minHeap(int capacity)			: initialize the min-heap with heap size as capacity.
 * isEmpty() 		 				: returns boolean object true/false. 
 * insertNode(int val) 				: Adds the element to the heap in min-heap order.
 * getMin()			 				: returns root value from the binary heap.
 * extractMin()		 				: deletes the min value from the binary heap and returns it. 
 * maxSize()		 				: returns the max size of the heap.
 * currentSize(T data) 				: returns the current size of the heap.
 * display() 		 				: displays the element of the tree in level-order (Breadth-first search)
 * 
 */

class minHeap {
	private Integer[] heapArray;
	private  int capacity;
	private int current_heap_size;

	public minHeap(int capacity) {
		this.capacity = capacity;
		heapArray = new Integer[capacity];
		current_heap_size = 0;
	}

	private void swap(int a, int b) {
		int temp = heapArray[a];
		heapArray[a] = heapArray[b];
		heapArray[b] = temp;
	}

	private int parent(int key) {
		return (key - 1) / 2;
	}

	private int left(int key) {
		return (key * 2) + 1;
	}

	private int right(int key) {
		return (key * 2) + 2;
	}

	private void minHeapify(int key) {
		int smallest = key;
		int left = left(key);
		int right = right(key);

		if (left < capacity && heapArray[left]!=null && heapArray[left] < heapArray[smallest]) {
			smallest = left;
		}

		if (right < capacity && heapArray[right]!=null && heapArray[right] < heapArray[smallest]) {
			smallest = right;
		}

		if (smallest != key) {
			int temp = heapArray[key];
			heapArray[key] = heapArray[smallest];
			heapArray[smallest] = temp;

			minHeapify(smallest);
		}
	}

	public boolean insertNode(int val) {
		if (current_heap_size == capacity) {
			System.out.println("Heap is full no space available.");
			return false;
		}
		int i = current_heap_size;
		heapArray[i] = val;
		current_heap_size++;

		while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
			swap(i, parent(i));
			i = parent(i);
		}
		
		System.out.println(val+" is added to the heap");

		return true;
	}
	public Integer getMin() {
		return (current_heap_size>0)? heapArray[0]:null;
	}

	public Integer extractMin() {
		if(current_heap_size==0) {
			System.out.println("No element available to delete.");
			return null;
		}
		int popElement = heapArray[0];
		heapArray[0] = heapArray[current_heap_size-1];
		current_heap_size--;
		minHeapify(0);
		
		System.out.println(popElement+" is deleted from the heap.");
		return popElement;
	}

	public void display() {
		if (current_heap_size == 0) {
			System.out.println("Heap is empty.");
			return;
		}
		for (int i = 0; i < current_heap_size; i++) {
			System.out.print(heapArray[i] + " ");
		}
		System.out.println();
	}
	
	public int maxSize() {
		return capacity;
	}
	public int currentSize() {
		return current_heap_size;
	}
	
	public boolean isEmpty() {
		return current_heap_size<=0;
	}

}
