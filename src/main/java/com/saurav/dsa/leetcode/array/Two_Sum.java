package src.main.java.com.saurav.dsa.leetcode.array;

/*
LeetCode 1 - Two Sum
Difficulty: Easy
Link: https://leetcode.com/problems/two-sum/

Approach:
- Uses a nested loop to check possible pairs of elements that sum to the target.
- The outer loop iterates with variable 'i' (starting from 1), and the inner loop uses 'j' to find the second index.
- The condition (nums[j] + nums[j - i]) == target checks pairs spaced 'i' apart in the array.
- Once a valid pair is found, the corresponding indices (j - i, j) are returned.

Complexity:
- Time Complexity: O(n²)
  (Two nested loops checking all pairs with variable distance.)
- Space Complexity: O(1)
  (Uses only constant extra space.)
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=1;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if((nums[j]+nums[j-i])==target){
                    return new int[]{(j-i),j};
                }
            }
        }
        return new int[2];
    }
}