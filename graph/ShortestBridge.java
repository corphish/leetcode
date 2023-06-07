// https://leetcode.com/problems/shortest-bridge
class Solution {
    public int shortestBridge(int[][] grid) {
        int k = 2, n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    floodFill(grid, i, j, k++);
                }
            }
        }

        int group1[] = new int[n * n], cg1 = 0;
        int group2[] = new int[n * n], cg2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    group1[cg1++] = i * n + j;
                } else if (grid[i][j] == 3) {
                    group2[cg2++] = i * n + j;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cg1; i++) {
            for (int j = 0; j < cg2; j++) {
                min = Math.min(min, distance(group1[i], group2[j], n));
            }
        }

        return min;
    }

    int distance(int c1, int c2, int n) {
        int x1 = c1/n, y1 = c1 % n;
        int x2 = c2/n, y2 = c2 % n;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2) - 1;
    }

    void floodFill(int[][] grid, int i, int j, int val) {
        grid[i][j] = val;

        if (i > 0) {
            if (grid[i - 1][j] == 1) {
                floodFill(grid, i - 1, j, val);
            }
        }

        if (i < grid.length - 1) {
            if (grid[i + 1][j] == 1) {
                floodFill(grid, i + 1, j, val);
            }
        }

        if (j > 0) {
            if (grid[i][j - 1] == 1) {
                floodFill(grid, i, j - 1, val);
            }
        }

        if (j < grid[0].length - 1) {
            if (grid[i][j + 1] == 1) {
                floodFill(grid, i, j + 1, val);
            }
        }
    }
}