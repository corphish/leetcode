// https://leetcode.com/problems/shortest-path-visiting-all-nodes
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        if (n == 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int[][] memo = new int[n][1 << n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            min = Math.min(min, dfs(graph, n, i, 0, visited, memo) - 1);
        }
        return min;
    }

    int dfs(
        int[][] graph,
        int n,
        int curr,
        int state,
        boolean[][] visited,
        int[][] memo
    ) {
        if (state == (1 << n) - 1) {
            return 0;
        }

        if (memo[curr][state] != 0) {
            return memo[curr][state];
        }

        int newState = setKthBit(state, curr);
        int min = Integer.MAX_VALUE/2;

        for (int node: graph[curr]) {
            if (!visited[curr][node]) {
                visited[curr][node] = true;
                min = Math.min(min, 1 + dfs(graph, n, node, newState, visited, memo));
                visited[curr][node] = false;
            }
        }

        memo[curr][state] = min;
        return min;
    }

    int setKthBit(int n, int k) {
        return (1 << k) | n;
    }
}