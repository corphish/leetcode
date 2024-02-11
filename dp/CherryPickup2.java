class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n + 1][m][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m/2; j++) {
                for (int k = 0; k < m/2; k++) {
                    int sum = grid[i][j] + (j == k ? 0 : grid[i][k]);
                    int max = j == 0 || k == 0 ? 0 : dp[i + 1][j - 1][k - 1];
                    dp[i][j][k] = max + sum;
                }
            }

            for (int j = m/2; j < m; j++) {
                for (int k = m/2; k < m; k++) {
                    int sum = grid[i][j] + (j == k ? 0 : grid[i][k]);
                    int max = j == m - 1 || k == m - 1 ? 0 : dp[i + 1][j + 1][k + 1];
                    dp[i][j][k] = max + sum;
                }
            }

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    int sum = grid[i][j] + (j == k ? 0 : grid[i][k]);
                    int max = 0;

                    for (int x = -1; x <= 1; x++) {
                        if (j == 0 && x == -1) continue;
                        if (j == m - 1 && x == 1) continue;
                        for (int y = -1; y <= 1; y++) {
                            if (k == 0 && y == -1) continue;
                            if (k == m - 1 && y == 1) continue;
                            max = Math.max(max, dp[i + 1][j + x][k + y]);
                        }
                    }

                    dp[i][j][k] = max + sum;
                }
            }
        }

        return dp[0][0][m - 1];
    }

    int max(
        int[][] grid,
        int i,
        int j, int k
    ) {
        int n = grid.length;
        int m = grid[0].length;

        if (i >= n) {
            return 0;
        }

        if (j < 0 || j >= m) {
            return 0;
        }

        if (k < 0 || k >= m) {
            return 0;
        }

        int sum = grid[i][j] + (j == k ? 0 : grid[i][k]);
        int max = 0;

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                max = Math.max(max, max(grid, i + 1, j + x, k + y));
            }
        }

        return max + sum;
    }
}