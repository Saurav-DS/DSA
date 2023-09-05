import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		//int[] arr = {43, 354, 7432, 1000, 1999, 12, 0, 43, 0, 0, 5};
		//int[] arr = {0};
		int[] arr = {};
		
		System.out.println("Before sorting :" + Arrays.toString(arr));
		sort(arr);
		System.out.println("After Sorting :" + Arrays.toString(arr));
	}
	/*
	 * Radix Sort Algorithm - below implementation can be used to sort int array
	 * 
	 * Time Complexity O(N + K) | Space Complexity O(N + K)
	 * 
	 * @param arr - int[] array to be sorted.
	 * 
	 * @return void.
	 * 
	 */
	
	public static void sort(int[] arr) {
		
		if(arr.length==0) {return;}
		
		int max = find_max(arr);
		
		for(int i=1;max/i>0;i*=10) {
			//System.out.println("Sorting for pos "+i);
			counting_sort(arr,i);
		}
	}
	
	public static void counting_sort(int[] arr, int pos) {
		int len = arr.length;
		int[] result = new int[len];
		int[] counting = new int[10];

		for (int i = 0; i < len; i++) {
			counting[(arr[i]/pos)%10]++;
		}

		for (int i = 1; i < 10; i++) {
			counting[i] += counting[i - 1];
		}

		for (int i = len-1; i >= 0; i--) {
			result[counting[(arr[i]/pos)%10] - 1] = arr[i];
			counting[(arr[i]/pos)%10]--;
			//System.out.println(Arrays.toString(result));
		}

		for(int i=0;i<len;i++) {
			arr[i] = result[i];
		}
	}
	
	// Utility method to find the max element of the array

	public static int find_max(int[] arr) {
		int max = arr[0];

		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}
		//System.out.println("Max "+max);
		return max;
	}

}
