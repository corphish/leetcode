// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid
class Solution {
    public int findMaxFish(int[][] grid) {
        int max = 0;
        boolean[] vis = new boolean[grid.length * grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    Arrays.fill(vis, false);
                    max = Math.max(max, max(grid, i, j, vis));
                }
            }
        }

        return max;
    }

    // [2 9]
    // [0 2]
    // [2 0]
    int max(
        int[][] grid,
        int i, int j,
        boolean[] vis
    ) {
        int pos = i * grid[0].length + j;
        Queue<Integer> q = new LinkedList<>();
        q.add(pos);
        int count = 0;

        while (!q.isEmpty()) {
            int top = q.poll();

            if (vis[top]) {
                continue;
            }

            int x = top/grid[0].length;
            int y = top % grid[0].length;

            vis[top] = true;
            count += grid[x][y];

            if (x > 0 && grid[x - 1][y] > 0) {
                q.add((x - 1) * grid[0].length + y);
            }

            if (x < grid.length - 1 && grid[x + 1][y] > 0) {
                q.add((x + 1) * grid[0].length + y);
            }

            if (y > 0 && grid[x][y - 1] > 0) {
                q.add(x * grid[0].length + y - 1);
            }

            if (y < grid[0].length - 1 && grid[x][y + 1] > 0) {
                q.add(x * grid[0].length + y + 1);
            }
        }

        return count;
    }
}