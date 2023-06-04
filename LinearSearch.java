import java.util.Scanner;

public class LinearSearch {
	public static void main(String[] args) {
		
		// Scanner object to get the user input from the console.
		Scanner sc = new Scanner(System.in);
		
		// Sample array with the value ranging 0-9
		// Array values can be in any order, sorted array is not required for Linear Search.
		int[] arr = {5,2,0,1,9,2,8,3,4,7};
		
		// Taking user input to be searched in the array.
		System.out.println("Enter Number to Search :");
		int find = sc.nextInt();
		sc.close();
		// Invoking the search and printing the value.
		System.out.println(search(arr,find));
	}
	/*
	 * Linear Search Algorithm
	 * Time Complexity O(N)
	 * Space Complexity O(1)
	 * 
	 * @param arr - int[] array to search for given value.
	 * @param find - int object to be searched in the array.
	 * @return String value stating if the value is present in the given array or not.
	 * 
	 */
	public static String search(int[] arr, int find) {
		
		for(int i : arr) {
			if(i==find) {
				return "Number present in array.";
			}
		}
		return "Number not present in array.";
	}

}
