// https://leetcode.com/problems/out-of-boundary-paths/
class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[maxMove + 1][m + 2][n + 2];
        int mod = 1000000007;

        for (int moves = 0; moves <= maxMove; moves++) {
            for (int x = 0; x <= m + 1; x++) {
                for (int y = 0; y <= n + 1; y++) {
                    int i = x - 1;
                    int j = y - 1;
                    if (i < 0 || i >= m) {
                        dp[moves][x][y] = 1;
                        continue;
                    }

                    if (j < 0 || j >= n) {
                        dp[moves][x][y] = 1;
                        continue;
                    }

                    if (moves == 0) {
                        dp[moves][x][y] = 0;
                        continue;
                    }
                }
            }
        }

        for (int moves = 1; moves <= maxMove; moves++) {
            for (int x = 1; x <= m; x++) {
                for (int y = 1; y <= n; y++) {
                    int i = x - 1;
                    int j = y - 1;

                    dp[moves][x][y] = 
                        ((dp[moves - 1][x + 1][y] + 
                        dp[moves - 1][x - 1][y]) % mod) + 
                        ((dp[moves - 1][x][y + 1] + 
                        dp[moves - 1][x][y - 1]) % mod); 

                    dp[moves][x][y] %= mod;
                }
            }
        }

        return dp[maxMove][startRow + 1][startColumn + 1];
    }
}