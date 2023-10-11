// https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons
class Solution {
    public int numOfArrays(int n, int m, int k) {
        long[][][] dp = new long[n][m + 1][k + 1];

        // Very important we do this as lots of results can be 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int x = 0; x <= k; x++) {
                    dp[i][j][x] = -1;
                }
            }
        }

        return (int) count(n, 0, m, 0, k, dp);
    }

    long count(
        int n,
        int i,
        int m,
        int last,
        int k,
        long[][][] dp
    ) {
        if (i == n) {
            return k == 0 ? 1 : 0;
        }

        if (k < 0) {
            return 0;
        }

        if (dp[i][last][k] != -1) {
            return dp[i][last][k];
        }

        long count = 0;

        // We choose not to spend search cost
        count += last * count(n, i + 1, m, last, k, dp);

        // Or, we choose to spend search cost
        for (int x = last + 1; x <= m; x++) {
            count += count(n, i + 1, m, x, k - 1, dp);
        }
        
        dp[i][last][k] = count % 1000000007;
        return dp[i][last][k];
    }
}