// https://leetcode.com/problems/maximum-sum-of-an-hourglass/
class Solution {
    public int maxSum(int[][] grid) {
        int max = 0;

        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                max = Math.max(
                    max,
                    grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] + 
                    grid[i][j] + 
                    grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1]
                );
            }
        }

        return max;
    }
}