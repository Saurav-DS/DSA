package src.main.java.com.saurav.dsa.queue;

import java.util.ArrayList;
import java.util.Comparator;

public class PriorityQueue {

	public static void main(String[] args) {
		HeapPriorityQueue<Integer, String> pq = new HeapPriorityQueue<Integer, String>();

		pq.display();
		System.out.println(pq.isEmpty());
		System.out.println(pq.size());
		pq.insert(5, "A");
		pq.insert(4, "B");
		pq.insert(9, "C");
		pq.insert(1, "D");
		pq.insert(7, "E");
		pq.insert(3, "F");
		pq.insert(8, "G");

		pq.display();
		System.out.println(pq.isEmpty());
		System.out.println(pq.size());

		pq.removeMin();

		pq.display();

		pq.insert(9, "D");

		pq.display();
		
	}

}
/*
 * Heap-based Priority Queue Class
 * 
 * size()		 : returns the size of the priority Queue.
 * isEmpty()		 : returns boolean true/false. 
 * insert(K key, V value): Adds the element to the priority queue in the key order (min-heap order of key) and returns the Entry<K, V> object. 
 * min()		 : returns the min Entry<K, V> from the priority queue.
 * removeMin()		 : removes the min Entry<K, V> from the priority queue.
 * display()		 : displays all the elements of the priority queue in level order.
 * 
 */

class HeapPriorityQueue<K, V> {

	private Comparator<K> comp;

	private ArrayList<Entry<K, V>> heap = new ArrayList<Entry<K, V>>();

	public HeapPriorityQueue() {
		this.comp = new DefaultComparator<K>();
	}

	public HeapPriorityQueue(Comparator<K> comp) {
		this.comp = comp;
	}

	private int parent(int j) {
		return (j - 1) / 2;
	}

	private int left(int j) {
		return (j * 2) + 1;
	}

	private int right(int j) {
		return (j * 2) + 2;
	}

	private boolean hasLeft(int j) {
		return left(j) < size();
	}

	private boolean hasRight(int j) {
		return right(j) < size();
	}

	private void swap(int i, int j) {
		Entry<K, V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}

	private int compare(Entry<K, V> a, Entry<K, V> b) {
		return comp.compare(a.getKey(), b.getKey());
	}

	private void upHeap(int j) {
		while (j > 0) {
			int p = parent(j);
			if (compare(heap.get(j), heap.get(p)) >= 0) {
				break;
			}
			swap(j, p);
			j = p;
		}
	}

	private void downHeap(int j) {

		int smallest = j;
		int left = left(j);
		int right = right(j);

		if (hasLeft(j) && compare(heap.get(smallest), heap.get(left)) > 0) {
			smallest = left;
		}
		if (hasRight(j) && compare(heap.get(smallest), heap.get(right)) > 0) {
			smallest = right;
		}
		if (smallest != j) {
			swap(smallest, j);
			downHeap(smallest);
		}
	}

	private boolean checkKey(K k) throws IllegalArgumentException {
		try {
			return (comp.compare(k, k) == 0);
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("Incompatible Key");
		}
	}

	public int size() {
		return heap.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public Entry<K, V> insert(K key, V value) {
		checkKey(key);
		Entry<K, V> entry = new Entry<K, V>(key, value);
		heap.add(entry);
		upHeap(size() - 1);
		return entry;
	}

	public Entry<K, V> min() {
		if (isEmpty()) {
			return null;
		}
		return heap.get(0);
	}

	public Entry<K, V> removeMin() {
		if (isEmpty()) {
			return null;
		}
		swap(0, size() - 1);
		Entry<K, V> remove = heap.remove(size() - 1);
		downHeap(0);

		return remove;
	}

	public void display() {
		heap.forEach(E -> System.out.print(E + "  "));
		System.out.println();
	}

}

/*
 * 
 * Entry class to store Key Value Pair to be added in the priority queue
 * 
 * It is simple POJO class for Key and Value.
 * 
 */

class Entry<K, V> {
	protected K key;
	protected V value;

	public Entry(K k, V v) {
		this.key = k;
		this.value = v;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K k) {
		this.key = k;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V v) {
		this.value = v;
	}

	@Override
	public String toString() {
		return "Entity{" + key + ", " + value + "}";
	}
}

/*
 * 
 * Default Comparator Implementation class
 * 
 * It will be our default comparator if custom comparator is not provided.
 * 
 */

class DefaultComparator<K> implements Comparator<K> {

	public int compare(K a, K b) throws ClassCastException {
		return ((Comparable<K>) a).compareTo(b);
	}
}
