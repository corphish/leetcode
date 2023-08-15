// https://leetcode.com/problems/knight-probability-in-chessboard
class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        if (k == 0) {
            return 1;
        }

        double[][][] dp = new double[k + 1][n][n];
        dp[0][row][column] = 1;
        double den = 1;
        double res = 0;

        for (int p = 1; p <= k; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[p][i][j] += safeGet(dp[p - 1], i - 2, j - 1);
                    dp[p][i][j] += safeGet(dp[p - 1], i - 2, j + 1);

                    dp[p][i][j] += safeGet(dp[p - 1], i + 2, j - 1);
                    dp[p][i][j] += safeGet(dp[p - 1], i + 2, j + 1);

                    dp[p][i][j] += safeGet(dp[p - 1], i - 1, j - 2);
                    dp[p][i][j] += safeGet(dp[p - 1], i - 1, j + 2);

                    dp[p][i][j] += safeGet(dp[p - 1], i + 1, j - 2);
                    dp[p][i][j] += safeGet(dp[p - 1], i + 1, j + 2);
                }
            }

            den *= 8;
        }

        for (double[] r: dp[k]) {
            for (double x: r) {
                res += x/den;
            }
        }

        return res;
    }

    double safeGet(double[][] arr, int x, int y) {
        return x < 0 || x >= arr.length || y < 0 || y >= arr[0].length ? 0 : arr[x][y];
    }
}