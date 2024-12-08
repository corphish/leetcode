// https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner
class Solution {
    final int INF = 12345678;
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // nb[i] -> Distance to 4 neighbors, INF if certain neighbor not present.
        // nb[i][0] -> up
        // nb[i][1] -> right
        // nb[i][2] -> down
        // nb[i][3] -> left
        int[][] nb = new int[m * n][4];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nb[count][0] = get(grid, i - 1, j);
                nb[count][1] = get(grid, i, j + 1);
                nb[count][2] = get(grid, i + 1, j);
                nb[count][3] = get(grid, i, j - 1);
                count += 1;
            }
        }

        return bfs(nb, n, m * n - 1);
    }

    // 0-1 BFS
    int bfs(int[][] nb, int n, int target) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] dist = new int[nb.length];
        Arrays.fill(dist, INF);

        q.add(0);
        dist[0] = 0;

        while (!q.isEmpty()) {
            int v = q.removeFirst();
            for (int i = 0; i < 4; i++) {
                int to = i == 0 ? v - n : i == 1 ? v + 1 : i == 2 ? v + n : v - 1;
                if (to < 0 || to > target) continue;
                if (dist[to] > dist[v] + nb[v][i]) {
                    dist[to] = dist[v] + nb[v][i];

                    if (nb[v][i] == 0) {
                        q.addFirst(to);
                    } else if (nb[v][i] == 1) {
                        q.addLast(to);
                    }
                }
            }
        }

        return dist[target];
    }

    int get(
        int[][] grid, int i, int j
    ) {
        return i >= grid.length || i < 0 || j >= grid[i].length || j < 0 ? INF : grid[i][j];
    }
}