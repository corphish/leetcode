// https://leetcode.com/problems/cheapest-flights-within-k-stops
class Solution {
    final int MAX = 1000000;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] adj = new int[n][n];

        for (int[] row: adj) Arrays.fill(row, MAX);

        for (int[] flight: flights) {
            adj[flight[0]][flight[1]] = flight[2];
        }

        int[][] memo = new int[n][k + 1];

        int res = min(n, adj, src, dst, k, memo);
        return res == MAX ? -1: res;
    }

    int min(int n, int[][] adj, int curr, int dest, int k, int[][] memo) {
        if (k < 0) {
            return MAX;
        }

        if (k == 0) {
            return adj[curr][dest];
        }

        if (memo[curr][k] != 0) {
            return memo[curr][k];
        }

        int min = adj[curr][dest];
        for (int i = 0; i < n; i++) {
            if (adj[curr][i] != MAX) {
                min = Math.min(min, adj[curr][i] + min(n, adj, i, dest, k - 1, memo));
            }
        }

        return memo[curr][k] = min;
    }
}