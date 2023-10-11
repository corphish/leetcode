// https://leetcode.com/problems/minimum-falling-path-sum-ii
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid.length];
        return min(grid, 0, -1, memo);
    }

    int min(int[][] grid, int row, int prevCol, int[][] memo) {
        if (row >= grid.length) {
            return 0;
        }

        if (prevCol != -1 && memo[row][prevCol] != 0) {
            return memo[row][prevCol];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid[row].length; i++) {
            if (i != prevCol) {
                min = Math.min(min, grid[row][i] + min(grid, row + 1, i, memo));
            }
        }

        if (prevCol != -1) {
            memo[row][prevCol] = min;
        }

        return min;
    }
}