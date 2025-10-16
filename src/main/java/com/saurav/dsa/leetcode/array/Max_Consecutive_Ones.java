package src.main.java.com.saurav.dsa.leetcode.array;

/*
LeetCode 485 - Max Consecutive Ones
Difficulty: Easy
Link: https://leetcode.com/problems/max-consecutive-ones/

Approach:
- Iterate through the array while counting consecutive 1s.
- If a 0 is encountered, update the maximum count and reset the current counter.
- After the loop, compare the final current count with the maximum to handle trailing 1s.

Complexity:
- Time Complexity: O(n)
  (Single pass through the array.)
- Space Complexity: O(1)
  (Uses only constant extra space.)
*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr = 0, max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                curr++;
            }
            else{
                max = Math.max(max,curr);
                curr = 0;
            }
        }

        return Math.max(curr,max);
    }
}