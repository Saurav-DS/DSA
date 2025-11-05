package src.main.java.com.saurav.dsa.leetcode.array;

/*
LeetCode 53 - Maximum Subarray
Difficulty: Medium
Link: https://leetcode.com/problems/maximum-subarray/

Approach (Kadane’s Algorithm):
- Iterate through the array while maintaining two variables:
  - `curr`: the maximum subarray sum ending at the current index.
  - `max`: the overall maximum subarray sum found so far.
- For each element, decide whether to start a new subarray at the current number 
  or continue the existing one by adding it to `curr`.
- Update `max` with the larger of the current `max` and `curr`.

Complexity:
- Time Complexity: O(n)
  (Single pass through the array.)
- Space Complexity: O(1)
  (Only two variables used for tracking current and maximum sums.)
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = 0;
        for(int i:nums){
            curr = ((curr+i)>i)?(curr+i):i;
            max = (curr>max)?curr:max;
        }

        return max;
    }
}