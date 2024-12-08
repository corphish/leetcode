// https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid
class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[] {0, 0, 0});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            if (top[1] == m - 1 && top[2] == n - 1) {
                return top[0];
            }

            if (vis[top[1]][top[2]]) {
                continue;
            }

            vis[top[1]][top[2]] = true;

            // Up, Right, Down, Left
            int ur = top[1] - 1, uc = top[2];
            int rr = top[1], rc = top[2] + 1;
            int dr = top[1] + 1, dc = top[2];
            int lr = top[1], lc = top[2] - 1;
            int wt = 0;

            if (ur >= 0) {
                wt = Math.abs(grid[ur][uc] - top[0]) % 2 == 0 ? 1 : 0;
                pq.add(new int[] { Math.max(top[0] + 1, grid[ur][uc] + wt), ur, uc });
            }

            if (rc < n) {
                wt = Math.abs(grid[rr][rc] - top[0]) % 2 == 0 ? 1 : 0;
                pq.add(new int[] { Math.max(top[0] + 1, grid[rr][rc] + wt), rr, rc });
            }

            if (dr < m) {
                wt = Math.abs(grid[dr][dc] - top[0]) % 2 == 0 ? 1 : 0;
                pq.add(new int[] { Math.max(top[0] + 1, grid[dr][dc] + wt), dr, dc });
            }

            if (lc >= 0) {
                wt = Math.abs(grid[lr][lc] - top[0]) % 2 == 0 ? 1 : 0;
                pq.add(new int[] { Math.max(top[0] + 1, grid[lr][lc] + wt), lr, lc });
            }
        }

        return -1;
    }
}