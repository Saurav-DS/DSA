import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// Sample array to be sorted using Insertion Sort.
		int[] arr = { 6, 1, 9, 3, 2, 0, 4, 5, 8, 7 };
		sort(arr);
		// Printing the sorted array.
		System.out.println(Arrays.toString(arr));
	}
	/*
	 * Insertion Sort Algorithm Time Complexity : O(N^2) Space Complexity : O(1)
	 * 
	 * @param arr - int[] array containing values to be sorted.
	 * 
	 * @return void
	 */

	public static void sort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int max = arr[i];
			int pos = i;
			while (pos > 0 && arr[pos - 1] > max) {
				arr[pos] = arr[pos - 1];
				pos--;
			}
			arr[pos] = max;
		}
	}

}
