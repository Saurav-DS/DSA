package src.main.java.com.saurav.dsa.leetcode.array;

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = 0;
        for(int i:nums){
            curr = ((curr+i)>i)?(curr+i):i;
            max = (curr>max)?curr:max;
            // curr = Math.max(i,(curr+i));
            // max = Math.max(curr,max);
        }

        return max;
    }
}