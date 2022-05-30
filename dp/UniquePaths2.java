// https://leetcode.com/problems/unique-paths-ii
class Solution {
    // Logic:
    // 1. Check if the ending point has obstacle, if yes, return 0.
    // 2. Build a grid dp with grid[1][1] = 1.
    // 3. Starting with i = 0 and j = 0 in grid, add grid[i][j] to grid[i + 1][j] and grid[i][j + 1] only if
    //    1. grid[i][j] != -1 and grid[i + 1][j] != -1 and grid[i][j + 1] != -1
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] grid = new int[m + 1][n + 1];
        
        // Base case
        grid[1][1] = 1;
        
        // If the ending point has obstacle, it is not possible to reach
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    grid[i + 1][j + 1] = -1;
                }
            }
        }
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (grid[i][j] != -1) {
                    safeAdd(grid, i + 1, j, grid[i][j]);
                    safeAdd(grid, i, j + 1, grid[i][j]);
                }
            }
        }
        
        return grid[m][n];
    }
    
    void safeAdd(int[][] grid, int i, int j, int x) {
        if (i < 0 || i >= grid.length) return;
        if (j < 0 || j >= grid[0].length) return;
        
        if (grid[i][j] != -1) grid[i][j] += x;
    }
}