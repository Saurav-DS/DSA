package src.main.java.com.saurav.dsa.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 17, 27, 13, 9, 55, 21, 30, 1, 34, 0 };
		int[] arr1 = { 6, 1, 9, 3, 2, 0, 4, 5, 8, 7 };
		int[] arr2 = {};
		int[] arr3 = { 2, 1, 0 };
		int[] arr4 = { 0, 1, 2, 3, 4, 5 };
		int[] arr5 = { 54, 23, 896, 135, 467, 435, 126, 754, 236, 9876, 563, 89, 1, 36, 783, 356, 890, 245, 56, 101 };
		QS(arr);
		QS(arr1);
		QS(arr2);
		QS(arr3);
		QS(arr4);
		QS(arr5);
	}
	public static void QS(int[] arr) {
		System.out.println("Unsorted :" + Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
		System.out.println("Sorted   :" + Arrays.toString(arr));
	}
	/*
	 * Quick Sort Algorithm
	 * 
	 * Time Complexity O(N log N) | Space Complexity O(1)
	 * 
	 * @param arr - int[]  unsorted array to be sorted.
	 * 
	 * @param first - first index of the array.
	 * 
	 * @param last - last index of the array.
	 * 
	 * @return void - all the changes are done in the original array.
	 * 
	 */
	public static void sort(int[] arr, int first, int last) {
		if (first >= last) {
			return;
		}
		int start = first;
		int end = last - 1, temp;
		while (start <= end) {
			while (start <= end && arr[last] > arr[start]) {
				start++;
			}
			while (start <= end && arr[last] < arr[end]) {
				end++;
			}
			if (start <= end) {
				temp = arr[end];
				arr[end--] = arr[start];
				arr[start++] = temp;
			}
		}
		temp = arr[start];
		arr[start] = arr[last];
		arr[last] = temp;
		sort(arr, first, start - 1);
		sort(arr, start + 1, last);
	}
}