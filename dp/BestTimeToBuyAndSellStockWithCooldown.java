// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // j -> 0 - buy, 1 - sell, 2 - cooldown
        int[][] dp = new int[n][3];

        // Init
        dp[0][0] = -prices[0];

        for (int i = 1; i < n; i++) {
            // If we want to buy we can only do it after cooldown
            // Or we can choose to not buy at all
            dp[i][0] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][0]);

            // We can choose to sell the stock or not sell
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][0]);

            // Cooldown value would be the sell value of last stock
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}