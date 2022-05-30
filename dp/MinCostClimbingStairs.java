// https://leetcode.com/problems/min-cost-climbing-stairs
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return Math.min(cost[0], cost[1]);
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for (int i = 2; i < cost.length; i++) {
            if (i < cost.length - 1) {
                dp[i] = Math.min(dp[i - 2] + cost[i], dp[i - 1] + cost[i]);
            } else {
                dp[i] = Math.min(
                    // 2 step from i - 2
                    dp[i - 2] + cost[i],

                    Math.min(
                        // 1 step from i - 1
                        dp[i - 1] + cost[i],

                        // 2 step from i - 1
                        dp[i - 1]
                    )
                );
            }
        }
        
        return dp[cost.length - 1];
    }
}