// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}