// https://leetcode.com/problems/maximal-network-rank/
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int max = 0;
        int[][] adj = new int[n][n + 1];

        for (int[] pair: roads) {
            adj[pair[0]][pair[1]] = 1;
            adj[pair[1]][pair[0]] = 1;

            adj[pair[0]][n] += 1;
            adj[pair[1]][n] += 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int count = adj[i][n] + adj[j][n];
                    if (adj[i][j] == 1) {
                        count -= 1;
                    }

                    max = Math.max(max, count);
                }
            }
        }

        return max;
    }
}