package src.main.java.com.saurav.dsa.leetcode.array;

/*
LeetCode 75 - Sort Colors
Difficulty: Medium
Link: https://leetcode.com/problems/sort-colors/

Approach (Dutch National Flag Algorithm):
- Use three pointers: 
  i (for 0s region), j (current index), and k (for 2s region).
- Traverse the array while j <= k:
  - If nums[j] == 0 → swap with nums[i], increment both i and j.
  - If nums[j] == 1 → move j ahead.
  - If nums[j] == 2 → swap with nums[k], decrement k (don't move j).
- This ensures all 0s are moved to the front, 2s to the end, and 1s remain in the middle.

Complexity:
- Time Complexity: O(n) 
  (Single pass through the array.)
- Space Complexity: O(1)
  (In-place sorting without extra storage.)
*/
class Solution {
    public void sortColors(int[] nums) {
        int i=0, j = 0, k = nums.length-1;
        while(j<=k){
            if(nums[j]==0){
                nums[i] = nums[j] + nums[i] - (nums[j] = nums[i]);
                i++;
                j++;
            }
            else if(nums[j]==1){
                j++;
            }
            else {
                nums[j] = nums[k] + nums[j] - (nums[k] = nums[j]);
                k--;
            }
        }
    }
}