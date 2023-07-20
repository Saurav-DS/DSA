import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] arr = { 5, 9, 0, 3, 1, 7, 2, 4, 8, 6 };

		System.out.println("Before : " + Arrays.toString(arr));
		heapSort(arr, arr.length);
		System.out.println("After : " + Arrays.toString(arr));
	}
	
	/*
	 * Heap Sort Algorithm | Time Complexity : O(N log (N)) | Space Complexity : O(1)
	 * 
	 * @param arr - int[] array containing values to be sorted.
	 * @param size - size of array.
	 * 
	 * @return void
	 */

	public static void heapSort(int[] arr, int size) {
		// Creating Max-Heap
		for (int i = ((size / 2) - 1); i >= 0; i--) {
			heapify(arr, size, i);
		}
		// Sorting
		for (int i = size - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0);
		}
	}
	/*
	 * heapify() - creates the max-heap for the given array
	 * @param arr - int[] array containing values to be sorted.
	 * @param size - size of array.
	 * @param i - index of current largest element.
	 * 
	 * @return void
	 */

	public static void heapify(int[] arr, int size, int i) {
		int largest = i;
		int left = i * 2 + 1;
		int right = i * 2 + 2;

		if (left < size && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < size && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			heapify(arr, size, largest);
		}
	}
}
