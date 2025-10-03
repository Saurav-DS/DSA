package src.main.java.com.saurav.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		// Sample array to be sorted using Insertion Sort.
		int[] arr = { 6, 1, 9, 3, 2, 0, 4, 5, 8, 7 };
		sort(arr, (arr.length - 1));
		// Printing the sorted array.
		System.out.println(Arrays.toString(arr));
	}
	/*
	 * Selection Sort Algorithm Time Complexity : O(N^2) Space Complexity : O(1)
	 * 
	 * @param arr - int[] array containing values to be sorted.
	 * 
	 * @return void
	 */

	public static void sort(int[] arr, int last) {
		if (last == 0) {
			return;
		}
		int temp = last;
		int max = arr[last];
		for (int i = 0; i < last; i++) {
			if (arr[i] > max) {
				max = arr[i];
				temp = i;
			}
		}
		arr[temp] = arr[last];
		arr[last--] = max;

		sort(arr, last);
	}
}
