// https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k/
class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        long[][][] memo = new long[grid.length][grid[0].length][k];
        return (int) count(grid, 0, 0, 0, k, memo);
    }

    long count(int[][] grid, int i, int j, int sum, int k, long[][][] memo) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            if ((sum + grid[i][j]) % k == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (i >= grid.length || j >= grid[0].length) {
            return 0;
        }

        if (memo[i][j][sum] != 0) {
            return memo[i][j][sum];
        }

        memo[i][j][sum] = count(grid, i + 1, j, (sum + grid[i][j]) % k, k, memo) +
            count(grid, i, j + 1, (sum + grid[i][j]) % k, k, memo);

        memo[i][j][sum] %= 1000000007;
        return memo[i][j][sum];
    }
}