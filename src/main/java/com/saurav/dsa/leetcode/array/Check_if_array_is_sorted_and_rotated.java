package src.main.java.com.saurav.dsa.leetcode.array;

/*
LeetCode 1752 - Check if Array Is Sorted and Rotated
Difficulty: Easy
Link: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

Approach:
- Traverse the array and count how many times an element is greater than its next element.
- Use modulo (%) to compare the last element with the first (circular comparison).
- For a sorted array, there are 0 such drops.
- For a sorted and rotated array, there will be exactly 1 such drop.
- If more than one drop exists, the array is not sorted and rotated.

Example:
nums = [3,4,5,1,2] → drops once (5 > 1) → return true
nums = [2,1,3,4] → drops twice (2 > 1 and 4 > 2) → return false

Complexity:
- Time Complexity: O(N)
- Space Complexity: O(1)
*/
class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%nums.length]){
                count++;
            }
        }
        return (count<=1)?true:false;
    }
}
