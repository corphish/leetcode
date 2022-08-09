// https://leetcode.com/problems/island-perimeter
class Solution {
    // The perimeter of the island is sum of number of edges of each land block which faces the water.
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int l = safeAccess(grid, i, j - 1);
                    int r = safeAccess(grid, i, j + 1);
                    int t = safeAccess(grid, i - 1, j);
                    int b = safeAccess(grid, i + 1, j);
                    
                    perimeter += 4 - l - r - b - t;
                }
            }
        }
        
        return perimeter;
    }
    
    int safeAccess(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) return 0;
        if (j < 0 || j >= grid[0].length) return 0;
        
        return grid[i][j];
    }
}