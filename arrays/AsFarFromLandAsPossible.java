// https://leetcode.com/problems/as-far-from-land-as-possible/
class Solution {
    public int maxDistance(int[][] grid) {
        int res = 0;
        while (true) {
            if (populate(grid)) {
                res++;
            } else {
                break;
            }
        }

        return res == 0 ? -1 : res;
    }

    boolean safePut(int[][] grid, int i, int j, int val) {
        if (i < 0 || i >= grid.length) return false;
        if (j < 0 || j >= grid[i].length) return false;
        if (grid[i][j] == val || grid[i][j] == -val) return false;

        grid[i][j] = val;
        return true;
    }

    boolean populate(int[][] grid) {
        boolean res = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    boolean left = safePut(grid, i, j - 1, -1);
                    boolean right = safePut(grid, i, j + 1, -1);
                    boolean top = safePut(grid, i - 1, j, -1);
                    boolean bottom = safePut(grid, i + 1, j, -1);

                    res |= top || bottom || left || right;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == -1) {
                    grid[i][j] = 1;
                }
            }
        }

        return res;
    }
}