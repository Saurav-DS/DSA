package src.main.java.com.saurav.dsa.sorting;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {

		//char[] arr = {'O','1','a','q','9','Z','S','A','5','a','z','b','3','c','z',',','e','?','A'};
		//char[] arr = {};
		//char[] arr = {'X'};
		char[] arr = { 45, 88, 0, 99, 45, 30, 101, 55, 255, 256, 300 };

		System.out.println("Before sorting :" + Arrays.toString(arr));
		arr = sort(arr);
		System.out.println("After Sorting :" + Arrays.toString(arr));
		/*
		 * for(char i : arr) { System.out.println(i+" "+(int)i); }
		 */
	}

	/*
	 * Counting Sort Algorithm - below implementation can be used to sort character array
	 * 
	 * Time Complexity O(N + K) | Space Complexity O(N + K)
	 * 
	 * @param arr - char[] unsorted array to be sorted.
	 * 
	 * @return char[] - Counting sort is not an in-place array.
	 * 
	 */

	public static char[] sort(char[] arr) {
		if(arr.length==0) {
			return arr;
		}
		int len = arr.length;
		int max = find_max(arr) + 1;
		char[] result = new char[len];
		int[] counting = new int[max];

		for (int i = 0; i < len; i++) {
			counting[arr[i]]++;
		}

		for (int i = 1; i < max; i++) {
			counting[i] += counting[i - 1];
		}

		for (int i = len; i > 0; i--) {
			result[counting[arr[i - 1]] - 1] = arr[i - 1];
			counting[arr[i - 1]]--;
		}

		return result;
	}
	
	// Utility method to find the max element of the array

	public static int find_max(char[] arr) {
		char max = arr[0];

		for (char i : arr) {
			if (i > max) {
				max = i;
			}
		}
		return (int) max;
	}

}
