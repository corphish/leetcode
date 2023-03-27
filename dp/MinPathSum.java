// // https://leetcode.com/problems/minimum-path-sum/
class Solution {
    // Logic: Firstly check for bounds
    // If bounds are valid, check if we have reached the end.
    // If yes, return the value of the grid, else try to travel towards right and bottom
    // and consider whichever yields the minimum value.
    // Memoize the value against the indexes i and j.
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return travel(grid, 0, 0, memo);
    }
    
    public int travel(int[][] grid, int i, int j, int[][] memo) {
        if (i < 0 || i >= grid.length) return Integer.MAX_VALUE;
        if (j < 0 || j >= grid[0].length) return Integer.MAX_VALUE;
        
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            return grid[i][j];
        }
        
        int res = grid[i][j] + Math.min(travel(grid, i + 1, j, memo), travel(grid, i, j + 1, memo));
        memo[i][j] = res;
        return res;
    }
}