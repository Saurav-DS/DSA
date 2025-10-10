package src.main.java.com.saurav.dsa.leetcode.array;

/*
LeetCode 26 - Remove Duplicates from Sorted Array
Difficulty: Easy
Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Approach:
- Use two pointers (`curr` and `i`) to track unique elements.
- `curr` points to the last unique element’s index.
- Iterate through the array:
  - If the current element `nums[i]` differs from `nums[curr]`,
    increment `curr` and assign `nums[curr] = nums[i]`.
- This effectively shifts unique elements to the front of the array.

Example:
nums = [1,1,2,3,3]
→ unique sequence formed as [1,2,3,...]
→ returns 3 (count of unique elements)

Complexity:
- Time Complexity: O(N)
- Space Complexity: O(1)
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[curr]!=nums[i]){
                nums[++curr] = nums[i];
            }
        }
        return curr+1;
    }
}
