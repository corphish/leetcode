// https://leetcode.com/problems/max-increase-to-keep-city-skyline
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        
        int initialSum = sumOf(grid);
        
        // Row max
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                rowMax[i] = Math.max(grid[i][j], rowMax[i]);
            }
        }
        
        // Col max
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                colMax[i] = Math.max(grid[j][i], colMax[i]);
            }
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int maxRow = rowMax[i], maxCol = colMax[j];
                grid[i][j] = Math.max(grid[i][j], Math.min(maxRow, maxCol));
            }
        }
        
        return sumOf(grid) - initialSum;
    }
    
    int sumOf(int[][] grid) {
        int sum = 0;
        for (int[] row: grid) {
            for (int x: row) {
                sum += x;
            }
        }
        
        return sum;
    }
}