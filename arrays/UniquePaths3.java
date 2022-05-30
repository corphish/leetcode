class Solution {
    // Logic:
    // 1. Find the starting point and start travelling from there.
    // 2. Travel in 4 directions.
    // 3. If the current position is out of bounds, return 0.
    // 4. If the current position is obstacle, return 0.
    // 5. If the current position is previously visited, return 0;
    // 6. If the current position is end point, check if all the blocks are travelled or not, if yes return 1 else 0.
    // 7. Else, we have to travel further, mark the current position as visited, visit the 4 directions recursively and sum them.
    // 8. After visiting the four directions, mark the current position to be false to enable back-tracking. If we do not
    //    do that we will get only 1 path.
    // 9. Return the sum.
    public int uniquePathsIII(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return travel(grid, i, j, visited);
                }
            }
        }
        
        return 0;
    }
    
    public int travel(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length) return 0;
        if (j < 0 || j >= grid[0].length) return 0;
        
        if (visited[i][j]) {
            return 0;
        }
        
        if (grid[i][j] == -1) {
            return 0;
        }
        
        if (grid[i][j] == 2) {
            if (isEveryBlockTraversed(grid, visited)) {
                return 1;
            } else {
                return 0;
            }
        }
        
        visited[i][j] = true;        
        
        int x = travel(grid, i - 1, j, visited) + travel(grid, i, j - 1, visited) + 
            travel(grid, i + 1, j, visited) + travel(grid, i, j + 1, visited);
        
        visited[i][j] = false;
        
        return x;
    }
    
    boolean isEveryBlockTraversed(int[][] grid, boolean[][] visited) {
        boolean res = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    res &= visited[i][j];
                }
            }
        }
        
        return res;
    }
}