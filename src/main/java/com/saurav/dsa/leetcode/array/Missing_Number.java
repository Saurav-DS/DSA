package src.main.java.com.saurav.dsa.leetcode.array;

/*
LeetCode 268 - Missing Number
Difficulty: Easy
Link: https://leetcode.com/problems/missing-number/

Approach (Sum Formula):
- The numbers range from 0 to n, so the expected sum of all numbers is n*(n+1)/2.
- Compute the actual sum of elements in the array.
- The missing number is the difference between the expected sum and the actual sum.

Complexity:
- Time Complexity: O(n)
  (One pass to compute the actual sum.)
- Space Complexity: O(1)
  (Only a few integer variables used.)
*/
class Solution {
    public int missingNumber(int[] nums) {
        int currSum = 0;
        int max = (nums.length*(nums.length+1))/2;
        for(int i : nums){
            currSum+=i;
        }

        return max-currSum;
    }
}
