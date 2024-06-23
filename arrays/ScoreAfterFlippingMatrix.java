// https://leetcode.com/problems/score-after-flipping-matrix
class Solution {
    public int matrixScore(int[][] grid) {
        // Row
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = (grid[i][j] + 1) % 2;
                }
            }
        }

        // Column
        for (int j = 0; j < grid[0].length; j++) {
            int zero = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 0) zero += 1;
            }

            if (zero > grid.length/2) {
                for (int i = 0; i < grid.length; i++) {
                    grid[i][j] = (grid[i][j] + 1) % 2;
                }
            }
        }

        int res = 0;
        for (int[] row: grid) {
            int k = 0;
            for (int x: row) k = k * 2 + x;
            res += k;
        }

        return res;
    }
}