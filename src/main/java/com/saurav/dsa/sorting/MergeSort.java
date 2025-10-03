package src.main.java.com.saurav.dsa.sorting;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// Sample array to be sorted using Insertion Sort.
		int[] arr = { 6, 1, 9, 3, 2, 0, 4, 5, 8, 7 };
		sort(arr);
		// Printing the sorted array.
		System.out.println(Arrays.toString(arr));
	}
	/*
	 * Merge Sort Algorithm | Time Complexity : O(N log (N)) | Space Complexity : O(N)
	 * 
	 * @param arr - int[] array containing values to be sorted.
	 * 
	 * @return void
	 */

	public static void sort(int[] arr) {
		if (arr.length == 1) {
			return;
		} else {
			int mid = (arr.length) / 2;

			int[] arr1 = Arrays.copyOfRange(arr, 0, mid);
			int[] arr2 = Arrays.copyOfRange(arr, mid, arr.length);

			sort(arr1);
			sort(arr2);

			int i = 0, j = 0;
			while ((i + j) < arr.length) {
				if (j == arr2.length || (i < arr1.length && arr2[j] > arr1[i])) {
					arr[i + j] = arr1[i++];
				} else {
					arr[i + j] = arr2[j++];
				}
			}
		}

	}
}
