class Solution {
    // Logic: Firstly check for bounds
    // If bounds are valid, check if we have reached the end.
    // If yes, return the value of the grid, else try to travel towards right and bottom
    // and consider whichever yields the minimum value.
    // Memoize the value against the indexes i and j.
    public int minPathSum(int[][] grid) {
        return travel(grid, 0, 0, new HashMap<>());
    }
    
    public int travel(int[][] grid, int i, int j, Map<String, Integer> memo) {
        if (i < 0 || i >= grid.length) return Integer.MAX_VALUE;
        if (j < 0 || j >= grid[0].length) return Integer.MAX_VALUE;
        
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            return grid[i][j];
        }
        
        int res = grid[i][j] + Math.min(travel(grid, i + 1, j, memo), travel(grid, i, j + 1, memo));
        memo.put(key, res);
        return res;
    }
}