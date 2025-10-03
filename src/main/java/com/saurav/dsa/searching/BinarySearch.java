package src.main.java.com.saurav.dsa.searching;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// Scanner object to get the user input from the console.
		Scanner sc = new Scanner(System.in);

		// Sample array with the value ranging 0-9
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		// Taking user input to be searched in the array.
		System.out.println("Enter Number to Search :");
		int find = sc.nextInt();
		sc.close();
		// Invoking the search and printing the value.
		System.out.println(search(arr, find,0,9));
	}

	/*
	 * Binary Search Algorithm Time Complexity O(log (N)) Space Complexity O(1)
	 * 
	 * @param arr - Sorted int[] array to search for given value.
	 * 
	 * @param find - int object to be searched in array.
	 * 
	 * @param start - starting point for array.
	 * 
	 * @param end - ending point for array.
	 * 
	 * @return String value stating if the value is present in the given array or
	 * not.
	 *
	 */
	public static String search(int[] arr, int find, int start, int end) {

		int mid = (start + end) / 2;

		if (start > end) {
			return "Number not present in array.";
		} else if (arr[mid] == find) {
			return "Number present in array.";
		} else if (arr[mid] > find) {
			return search(arr, find, start, (mid - 1));
		} else {
			return search(arr, find, (mid + 1), end);
		}
	}
}
