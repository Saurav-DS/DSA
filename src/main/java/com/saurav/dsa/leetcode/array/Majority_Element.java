package src.main.java.com.saurav.dsa.leetcode.array;

/*
LeetCode 169 - Majority Element
Difficulty: Easy
Link: https://leetcode.com/problems/majority-element/

Approach (Boyer–Moore Voting Algorithm):
- Initialize the first element as the candidate (`major`) and set count = 1.
- Iterate through the array:
  - If the current element equals the candidate, increment the count.
  - Otherwise, decrement the count.
  - When count reaches 0, assign the current element as the new candidate and reset count = 1.
- The final candidate after one full pass is guaranteed to be the majority element 
  (appears more than n/2 times) per the problem’s guarantee.

Complexity:
- Time Complexity: O(n)
  (Single traversal through the array.)
- Space Complexity: O(1)
  (Uses constant extra space.)
*/
class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(count==0){
                major = nums[i];
                count=1;
            }
            else if(nums[i]==major){
                count++;
            }
            else {
                count--;
            }
        }
        return major;
    }
}
