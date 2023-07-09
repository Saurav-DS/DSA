import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {6,9,1,4,2,8,3,7,5,0};
		System.out.println("Before sorting : "+Arrays.toString(arr));
		sort(arr);
		System.out.println("After Sorting : "+Arrays.toString(arr));
	}
	
	/*
	 * Bubble Sort Algorithm Time Complexity : O(N^2) Space Complexity : O(1)
	 * 
	 * @param arr - int[] array containing values to be sorted.
	 * 
	 * @return void
	 */
	
	public static void sort(int[] arr) {
		
		int temp;
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

}
