/**
 * LeetCode 121 - Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * Pattern: Kadane Variant / Prefix Minimum
 * 
 * 🧠 Core Idea
 * - Track minPrice
 * - Calculate profit at each step
 * - Update maxProfit
 * 
 * ⏱ Time Complexity: O(n)
 * 💾 Space Complexity: O(1)
 */
class LC0121BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            if (price < minPrice) {
                minPrice = price;
            }
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
