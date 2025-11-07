package src.main.java.com.saurav.dsa.leetcode.array;

/*
LeetCode 121 - Best Time to Buy and Sell Stock
Difficulty: Easy
Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Approach:
- Track the minimum stock price encountered so far while iterating through the array.
- For each price, calculate potential profit = current price - minimum price.
- Update the maximum profit if the current profit is greater.
- Update the minimum price if the current price is lower than the existing minimum.

Complexity:
- Time Complexity: O(n)
  (Single pass through the array.)
- Space Complexity: O(1)
  (Uses only constant extra variables.)
*/
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            int cost = prices[i]-min;
            profit = Math.max(profit,cost);
            min = Math.min(min,prices[i]);
        }

        return profit;
    }
}