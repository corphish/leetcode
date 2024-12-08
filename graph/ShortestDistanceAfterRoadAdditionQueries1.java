// https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[][] nb = new int[n][n];
        int[] start = new int[n];
        boolean[] vis = new boolean[n];
        int[] res = new int[queries.length];

        for (int i = 0; i < n - 1; i++) {
            nb[i][start[i]] = i + 1;
            start[i] += 1;
        }

        for (int i = 0; i < queries.length; i++) {
            nb[queries[i][0]][start[queries[i][0]]] = queries[i][1];
            start[queries[i][0]] += 1;
            res[i] = bfs(nb, start, vis);
        }

        return res;
    }

    int bfs(int[][] nb, int[] start, boolean[] vis) {
        Deque<Integer> q = new ArrayDeque<>();
        Arrays.fill(vis, false);
        q.add(0);
        int res = 0;

        while (!q.isEmpty()) {
            Deque<Integer> t = new ArrayDeque<>();
            while (!q.isEmpty()) {
                int p = q.poll();

                if (p == vis.length - 1) {
                    return res;
                }

                vis[p] = true;
                for (int i = 0; i < start[p]; i++) {
                    if (!vis[nb[p][i]]) {
                        t.add(nb[p][i]);
                    }
                }
            }

            q = t;
            res += 1;
        }

        return res;
    }
}