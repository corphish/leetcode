// https://leetcode.com/problems/maximum-multiplication-score
class Solution {
    public long maxScore(int[] a, int[] b) {
        long[][] dp = new long[a.length + 1][b.length + 1];

        for (int i = a.length; i >= 0; i--) {
            for (int j = b.length; j >= 0; j--) {
                if (i == a.length) {
                    dp[i][j] = 0L;
                } else if (j == b.length) {
                    dp[i][j] = 6400L * Integer.MIN_VALUE;
                } else {
                    dp[i][j] = Math.max(
                        dp[i][j + 1],
                        1L * a[i] * b[j] + dp[i + 1][j + 1]
                    );
                }
            }
        }

        return dp[0][0];
    }

    long max(
        int[] a, int[] b,
        int i, int j
    ) {
        if (i == a.length) {
            return 0;
        }

        if (j == b.length) {
            return 64L * Integer.MIN_VALUE;
        }

        return Math.max(
            max(a, b, i, j + 1),
            a[i] * b[j] + max(a, b, i + 1, j + 1)
        );
    }
}