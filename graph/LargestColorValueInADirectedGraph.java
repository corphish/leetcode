// https://leetcode.com/problems/largest-color-value-in-a-directed-graph
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] visited = new boolean[colors.length()], session = visited.clone();
        int max = 0;

        for (int[] edge: edges) {
            if (edge[0] == edge[1]) return -1;
            adj.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
        }

        int[][] dp = new int[colors.length()][26];
        for (int i = 0; i < colors.length(); i++) {
            if (!visited[i]) {
                boolean res = dfs(adj, i, colors, visited, session, dp);
                if (res) {
                    return -1;
                }
            }
        }

        for (int[] row: dp) {
            for (int val: row) {
                max = Math.max(val, max);
            }
        }

        return max;
    }

    boolean dfs(
        Map<Integer, List<Integer>> adj, 
        int i, 
        String color, 
        boolean[] visited, 
        boolean[] session, 
        int[][] dp
        ) {
        if (session[i]) {
            return true;
        }

        if (visited[i]) {
            return false;
        }

        visited[i] = true;
        session[i] = true;

        boolean res = false;
        for (int x: adj.getOrDefault(i, List.of())) {
            res = res || dfs(adj, x, color, visited, session, dp);
            for (int j = 0; j < 26; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[x][j]);
            }
        }

        session[i] = false;

        dp[i][color.charAt(i) - 'a'] += 1;

        return res;
    }
}