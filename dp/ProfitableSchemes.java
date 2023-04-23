// https://leetcode.com/problems/profitable-schemes
class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        long[][][] dp = new long[n + 1][group.length][minProfit + 1];
        for (long[][] row: dp) {
            for (long[] row1: row)
                Arrays.fill(row1, -1);
        }
        return (int) count(n, 0, minProfit, group, profit, dp);
    }

    long count(int n, int i, int minProfit, int[] group, int[] profit, long[][][] dp) {
        long res = minProfit <= 0 ? 1 : 0;

        if (n == 0) {
            return res;
        }

        if (i >= group.length) {
            return res;
        }

        int ix = Math.max(0, minProfit);

        if (dp[n][i][ix] != -1) {
            return dp[n][i][ix];
        }

        if (group[i] <= n) {
            return dp[n][i][ix] = (count(n - group[i], i + 1, minProfit - profit[i], group, profit, dp) + 
                count(n, i + 1, minProfit, group, profit, dp)) % 1000000007;
        } else {
            return dp[n][i][ix] = count(n, i + 1, minProfit, group, profit, dp) % 1000000007;
        }
    }
}