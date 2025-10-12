package src.main.java.com.saurav.dsa.leetcode.array;

/*
LeetCode 283 - Move Zeroes
Difficulty: Easy
Link: https://leetcode.com/problems/move-zeroes/

Approach:
- Use a two-pointer strategy to shift non-zero elements forward.
- `temp` keeps track of the next position to place a non-zero element.
- Iterate through the array:
  - If the current element is non-zero, assign it to `nums[temp]` and increment `temp`.
- After processing all elements, fill the remaining positions (from `temp` to end) with zeros.
- This approach preserves the relative order of non-zero elements.

Example:
Input: [0,1,0,3,12]
After first loop: [1,3,12,?,?] (temp = 3)
Fill remaining with zeros: [1,3,12,0,0]

Complexity:
- Time Complexity: O(n)
- Space Complexity: O(1)
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int temp = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[temp++] = nums[i];
            }
        }
        for(int i=temp;i<n;i++){
            nums[i]=0;
        }
    }
}
