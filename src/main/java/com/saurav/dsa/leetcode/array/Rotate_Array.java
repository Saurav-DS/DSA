package src.main.java.com.saurav.dsa.leetcode.array;

/*
LeetCode 189 - Rotate Array
Difficulty: Medium
Link: https://leetcode.com/problems/rotate-array/

Approach:
- The problem asks to rotate the array to the right by k steps.
- Instead of using extra space, we can reverse parts of the array in-place.
- Steps:
  1. Normalize k as k = k % n (since rotating n times results in the same array).
  2. Reverse the entire array.
  3. Reverse the first k elements.
  4. Reverse the remaining n - k elements.
- The array ends up rotated in O(1) extra space and O(n) time.

Optimization Detail:
- The reverse operation swaps elements without using a temporary variable by using:
  `a = b + a - (b = a);`
  This arithmetic trick swaps two numbers in-place.

Complexity:
- Time Complexity: O(n)
- Space Complexity: O(1)
*/
class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int n = nums.length-1;
        reverse(nums, 0, n);
        reverse(nums, 0, k-1);
        reverse(nums, k, n);
    }
    public void reverse(int[] nums, int start, int end){
        while(start<end){
            nums[start] = nums[end] + nums[start] - (nums[end] = nums[start]);
            start++;end--;
        }
    }
}
