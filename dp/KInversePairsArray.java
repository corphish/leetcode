// https://leetcode.com/problems/k-inverse-pairs-array/submissions
class Solution {
    public int kInversePairs(int n, int k) {
        long[][] dp = new long[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                if (i == 0) {
                    continue;
                }

                for (int x = 0; x <= i; x++) {
                    if (j - x < 0) break;
                    dp[i][j] += dp[i - 1][j - x];
                }

                dp[i][j] %= 1000000007;
            }
        }

        // return count(n, n - 1, k);
        return (int) dp[n - 1][k];
    }

    int count(
        int n,
        int i,
        int k
    ) {
        if (k == 0) {
            return 1;
        }

        if (i < 0) {
            return 0;
        }

        int count = 0;

        // For current index we put the minimum number available
        for (int j = 0; j <= i; j++) {
            count += count(n, i - 1, k - j);
        }

        return count;
    }
}