// https://leetcode.com/problems/ones-and-zeroes/
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[] ones = new int[strs.length];
        int[] zeroes = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            int one = 0, zero = 0;
            for (char c: strs[i].toCharArray()) {
                if (c == '0') {
                    zero += 1;
                } else {
                    one += 1;
                }
            }

            ones[i] = one;
            zeroes[i] = zero;
        }

        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = strs.length - 1; i >= 0; i--) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (i == strs.length) {
                        dp[i][j][k] = 0;
                    } else {
                        int max = dp[i + 1][j][k];
                        if (ones[i] <= k && zeroes[i] <= j) {
                            max = Math.max(max, 1 + dp[i + 1][j - zeroes[i]][k - ones[i]]);
                        } 

                        dp[i][j][k] = max;
                    }
                }
            }
        }

        return dp[0][m][n];
    }

    int max(
        int[] ones,
        int[] zeroes,
        int i,
        int m, int n
    ) {
        if (i == ones.length) {
            return 0;
        }

        int max = max(ones, zeroes, i + 1, m, n);

        if (ones[i] <= n && zeroes[i] <= m) {
            max = Math.max(max, 1 + max(ones, zeroes, i + 1, m - zeroes[i], n - ones[i]));
        }

        return max;
    }
}