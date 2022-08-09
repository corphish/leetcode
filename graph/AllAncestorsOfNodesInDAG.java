// https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph
class Solution {
    // We build a directed graph.
    // The edges specified the input specifies that there is a edge from n1 to n2.
    // However, we build the graph by considering that the edge is from n2 to n1 (basically reverse the direction of all edges).
    // Now for all the vertices, we perform a dfs and trace the path. The ancestor of that vertex will be all nodes in the traced path except itself.
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int[] edge: edges) {
            List<Integer> l = adj.getOrDefault(edge[1], new ArrayList<>());
            l.add(edge[0]);
            adj.put(edge[1], l);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new TreeSet<>();
            boolean[] visited = new boolean[n];
            dfs(adj, i, set, visited);
            set.remove(i);
            res.add(new ArrayList<>(set));
        }
        
        return res;
    }
    
    void dfs(
        Map<Integer, List<Integer>> adj, 
        int src,
        Set<Integer> path,
        boolean[] visited
    ) {
        path.add(src);
        
        visited[src] = true;
        
        for (int x: adj.getOrDefault(src, List.of())) {
            if (!visited[x]) {
                dfs(adj, x, path, visited);
            }
        }
    }
}