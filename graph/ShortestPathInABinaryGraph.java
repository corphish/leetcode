// https://leetcode.com/problems/shortest-path-in-binary-matrix/
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Deque<Integer> queue = new ArrayDeque<>();
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        if (grid[0][0] == 0) {
            queue.add(0);
        }

        int dist = 1;
        while (!queue.isEmpty()) {
            Deque<Integer> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                int top = queue.removeFirst();
                int x = top/n;
                int y = top % n;

                if (x == n - 1 && y == n - 1) {
                    return dist;
                }

                int tl = safeGet(grid, x - 1, y - 1);
                int t = safeGet(grid, x - 1, y);
                int tr = safeGet(grid, x - 1, y + 1);
                int l = safeGet(grid, x, y - 1);
                int r = safeGet(grid, x, y + 1);
                int bl = safeGet(grid, x + 1, y - 1);
                int b = safeGet(grid, x + 1, y);
                int br = safeGet(grid, x + 1, y + 1);

                if (tl == 0 && !visited[x - 1][y - 1]) {
                    visited[x - 1][y - 1] = true;
                    temp.add((x - 1) * n + (y - 1));
                }

                if (t == 0 && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    temp.add((x - 1) * n + (y));
                }

                if (tr == 0 && !visited[x - 1][y + 1]) {
                    visited[x - 1][y + 1] = true;
                    temp.add((x - 1) * n + (y + 1));
                }

                if (l == 0 && !visited[x][y - 1]) {
                    visited[x][y - 1] = true;
                    temp.add((x) * n + (y - 1));
                }

                if (r == 0 && !visited[x][y + 1]) {
                    visited[x][y + 1] = true;
                    temp.add((x) * n + (y + 1));
                }

                if (bl == 0 && !visited[x + 1][y - 1]) {
                    visited[x + 1][y - 1] = true;
                    temp.add((x + 1) * n + (y - 1));
                }

                if (b == 0 && !visited[x + 1][y]) {
                    visited[x + 1][y] = true;
                    temp.add((x + 1) * n + (y));
                }

                if (br == 0 && !visited[x + 1][y + 1]) {
                    visited[x + 1][y + 1] = true;
                    temp.add((x + 1) * n + (y + 1));
                }
            }

            queue = temp;
            dist += 1;
        }

        return -1;
    }

    int safeGet(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[x].length ? grid[x][y] : 1;
    }
}