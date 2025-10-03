package src.main.java.com.saurav.dsa.hashmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class HashMap {

	public static void main(String[] args) {

		// Initialization of HashMap
		Map<Integer, String> hashMap = new Map<Integer, String>();
		// Negative checks on empty map
		System.out.println(hashMap.capacity()); // Size of empty map
		System.out.println(hashMap.get(10)); // Get Method negative scenario
		System.out.println(hashMap.remove(10)); // remove Method negative scenario

		hashMap.put(5, "Saurav");
		hashMap.put(11, "Gaurav");
		hashMap.put(25, "Shweta");
		hashMap.put(23, "Komal");
		hashMap.put(2, "Priyanka");
		hashMap.put(19, "Gunjan");

		System.out.println("Get Method :" + hashMap.get(25)); // get method, positive scenario
		System.out.println("Get Method :" + hashMap.get(3)); // get method, negative scenario
		
		hashMap.put(25, "Shweta Chauhan"); // updating existing value

		// Iterating through all the values of Map
		Iterator<Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// remove method, positive scenario
		System.out.println("After remove");
		hashMap.remove(19);

		System.out.println(hashMap.get(19));

		iterator = hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// Map size before resizing
		System.out.println(hashMap.size() + " " + hashMap.capacity());

		hashMap.put(17, "Gunjan");
		hashMap.put(13, "Deepa");
		hashMap.put(9, "Rahul");
		hashMap.put(7, "Palak");
		hashMap.put(33, "Jatin");
		hashMap.put(45, "Ram");
		hashMap.put(55, "Shyam");

		iterator = hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// Map size after resizing
		System.out.println(hashMap.size() + " " + hashMap.capacity());

	}
}
/*
 * HashMap Class
 * 
 * 3 Key techniques/ properties of below implementation:
 * 1. Follows the properties of separate chaining.
 * 2. MAD(Multiply Add Divide) method for collision handling.
 * 3. Auto-resizing of bucket array whenever the HashMap is filled more than 69%.
 * 
 * size()						: returns the number of elements in the map.
 * capacity()					: returns the capacity of the hashMap.
 * get()						: return the value associated to the provided key.
 * 								  @param K Key
 * 								  @return V value
 * put()						: inserts the provided key value pair in the map or update the existing entity if duplicate key is provided.
 * 								  @param K key, V value
 * 								  @return V value
 * remove()						: removed the entity associated with the provided key from the map.
 * 								  @param K key
 * 								  @return V value
 * entrySet()					: returns the iterable of map entry.
 * 								  @return Iterable<Entry<K,V>
 * 
 */

class Map<K, V> {

	private int n = 0;
	private int capacity;
	private int prime;
	private long scale, shift;

	private UnsortedMap<K, V>[] table;

	public Map(int cap, int p) {
		this.capacity = cap;
		this.prime = p;
		Random rand = new Random();
		scale = rand.nextInt(p - 1) + 1; // range [1 to p-1]
		shift = rand.nextInt(p); // range [0 to p-1]
		createTable();
	}

	public Map(int cap) {
		this(cap, 109345121); // Any large Prime number
	}

	public Map() {
		this(15); // Default initial size of map
	}

	public int size() {
		return n;
	}
	public int capacity() {
		return capacity;
	}

	// Calculating hashValue using MAD collision handling technique
	private int hashValue(K key) {
		return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
	}

	@SuppressWarnings("unchecked")
	private void createTable() {
		this.table = (UnsortedMap<K,V>[])new UnsortedMap[capacity];
		for (int i = 0; i < table.length; i++)
			table[i] = new UnsortedMap<>();

		n = 0;

		// System.out.println(Arrays.toString(table));
	}

	public V get(K key) {
		return table[hashValue(key)].get(key);
	}

	public V put(K key, V value) {
		int hashValue = hashValue(key);
		V val = table[hashValue].put(key, value);

		if (val == null) {
			n++;
		}

		// Resizing to avoid collisions
		// System.out.println("Condition check :"+ (float)n/table.length+" "+
		// ((float)n/table.length>=0.7));
		if ((float) n / table.length >= 0.7) {
			this.capacity = (capacity * 2) - 1;
			resize();
		}

		return val;
	}

	public V remove(K key) {
		int hashValue = hashValue(key);

		V value = table[hashValue].remove(key);
		if (value != null) {
			n--;
		}

		return value;
	}

	private void resize() {
		ArrayList<Entry<K, V>> buffer = new ArrayList<>();
		for (Entry<K, V> entry : entrySet()) {
			buffer.add(entry);
		}

		createTable();

		for (Entry<K, V> entry : buffer) {
			put(entry.getKey(), entry.getValue());
		}
	}

	public Iterable<Entry<K, V>> entrySet() {
		ArrayList<Entry<K, V>> buffer = new ArrayList<Entry<K, V>>();

		for (UnsortedMap<K, V> bucket : table) {
			if (bucket != null) {
				for (Entry<K, V> entry : bucket.entrySet()) {
					buffer.add(entry);
				}
			}
		}

		return buffer;
	}

}

class UnsortedMap<K, V> {

	private ArrayList<Entry<K, V>> bucket = new ArrayList<Entry<K, V>>();

	// Utility
	private int findIndex(K key) {

		for (int i = 0; i < bucket.size(); i++) {
			if (bucket.get(i).getKey().equals(key)) {
				return i;
			}
		}

		return -1;
	}

	public int size() {
		return bucket.size();
	}

	public V get(K key) {
		int index = findIndex(key);
		if (index == -1) {
			return null;
		}
		return bucket.get(index).getValue();
	}

	public V put(K key, V value) {
		int index = findIndex(key);
		if (index == -1) {
			bucket.add(new Entry<K, V>(key, value));
			return null;
		}
		bucket.get(index).setValue(value);

		return value;
	}

	public V remove(K key) {
		int index = findIndex(key);
		if (index == -1) {
			return null;
		}

		V value = bucket.get(index).getValue();
		bucket.remove(index);

		return value;
	}

	public class EntryIterator implements Iterator<Entry<K, V>> {

		private int j = 0;

		@Override
		public boolean hasNext() {
			return j < size();
		}

		@Override
		public Entry<K, V> next() {
			if (j == size()) {
				throw new NoSuchElementException();
			}
			return bucket.get(j++);
		}
	}

	public class EntryIterable implements Iterable<Entry<K, V>> {

		@Override
		public Iterator<Entry<K, V>> iterator() {
			return new EntryIterator();
		}
	}

	public Iterable<Entry<K, V>> entrySet() {
		return new EntryIterable();
	}

}

class Entry<K, V> {
	private K key;
	private V value;

	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public String toString() {
		return "{ Key : " + key + ", Value : " + value + " }";
	}
}
