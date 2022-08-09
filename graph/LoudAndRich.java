// https://leetcode.com/problems/loud-and-rich
class Solution {
    // Build a directed graph, where a node A has an edge to node B, if B is richer than A.
    // Build adjacency list of the graph.
    // For each vertex from 0..n, perform a dfs, keeping track of the min quiet value and its index. res[i] will be that index.
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        int n = quiet.length;
        
        for (int[] rel: richer) {
            Set<Integer> l = adj.getOrDefault(rel[1], new HashSet<>());
            l.add(rel[0]);
            adj.put(rel[1], l);
        }
        
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            res[i] = dfs(adj, i, quiet, visited)[1];
        }
        
        return res;
    }
    
    // Returns an array of 2 ints, where arr[0] is the min quiet value and min[1] is the index whose quiet value is min[0].
    int[] dfs(Map<Integer, Set<Integer>> adj, int v, int[] quiet, boolean[] visited) {
        visited[v] = true;
        
        int min = quiet[v];
        int minIndex = v;
        
        for (int x: adj.getOrDefault(v, Set.of())) {
            if (!visited[x]) {
                int[] res = dfs(adj, x, quiet, visited);
                if (res[0] < min) {
                    min = res[0];
                    minIndex = res[1];
                }
            }
        }
        
        return new int[] {min, minIndex};
    }
}