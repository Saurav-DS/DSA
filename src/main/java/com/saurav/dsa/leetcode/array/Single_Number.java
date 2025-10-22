package src.main.java.com.saurav.dsa.leetcode.array;

/*
LeetCode 136 - Single Number
Difficulty: Easy
Link: https://leetcode.com/problems/single-number/

Approach:
- Initialize a variable `val` to 0.
- Iterate through all numbers in the array and perform XOR (`^`) between `val` and each number.
- Using XOR properties: a ^ a = 0 and a ^ 0 = a, all duplicate numbers cancel out, leaving only the unique number.

Complexity:
- Time Complexity: O(n)
  (Single pass through the array.)
- Space Complexity: O(1)
  (Uses only a constant amount of extra space.)
*/
class Solution {
    public int singleNumber(int[] nums) {
        int val = 0;
        for(int i : nums){
            val = val^i;
        }
        return val;
    }
}