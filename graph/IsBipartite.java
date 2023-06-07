// https://leetcode.com/problems/is-graph-bipartite
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];

        for (int i = 0; i < graph.length; i++)
            color(graph, i, colors);

        for (int x: colors) {
            if (x > 2) return false;
        }
        return true;
    }

    void color(int[][] graph, int u, int[] colors) {
        if (colors[u] > 0) {
            return;
        }

        boolean[] used = new boolean[graph.length + 1];
        for (int v: graph[u]) {
            used[colors[v]] = true;
        }

        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                colors[u] = Math.max(1, i);
                break;
            }
        }

        for (int v: graph[u]) {
            color(graph, v, colors);
        }
    }
}