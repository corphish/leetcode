// https://leetcode.com/problems/number-of-increasing-paths-in-a-grid
class Solution {
    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] dp = new long[m][n];
        long sum = 0;
        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
                map.computeIfAbsent(grid[i][j], x -> new ArrayList<>()).add(i * n + j);
            }
        }

        for (var e: map.entrySet()) {
            for (int ix: e.getValue()) {
                int x = ix/n;
                int y = ix % n;

                if (safeGet(grid, x - 1, y) < grid[x][y]) {
                    dp[x][y] += dp[x - 1][y];
                }

                if (safeGet(grid, x + 1, y) < grid[x][y]) {
                    dp[x][y] += dp[x + 1][y];
                }

                if (safeGet(grid, x, y - 1) < grid[x][y]) {
                    dp[x][y] += dp[x][y - 1];
                }

                if (safeGet(grid, x, y + 1) < grid[x][y]) {
                    dp[x][y] += dp[x][y + 1];
                }

                
                dp[x][y] %= 1000000007;
                sum += dp[x][y];
            }
        }

        return (int) (sum % 1000000007);
    }

    int safeGet(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) return Integer.MAX_VALUE;
        if (j < 0 || j >= grid[0].length) return Integer.MAX_VALUE;

        return grid[i][j];
    }
}