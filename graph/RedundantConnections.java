// https://leetcode.com/problems/redundant-connection
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        // Build adjacency list for undirected graph
        for (int[] edge: edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        int[] res = new int[] {};
        
        for (int[] edge: edges) {
            // We can discard this edge if there are 2 or more edges that go out/come in
            // from each of the vertex represented by the edge.
            
            visited.clear();
            
            if (adj.getOrDefault(edge[0], List.of()).size() > 1 && adj.getOrDefault(edge[1], List.of()).size() > 1) {
                // We can discard this set, see if we can dfs through the entire graph having this
                // edge discarded
                dfs(adj, edge[0], edge, visited);
                
                // We know all the nodes are visited if the size of set is n
                if (visited.size() == n) {
                    //System.out.println("Can remove " + Arrays.toString(edge));
                    res = edge;
                }
            }
        }
        
        return res;
    }
    
    void dfs(Map<Integer, List<Integer>> adj, int curr, int[] discarded, Set<Integer> visited) {
        if (visited.contains(curr)) {
            return;
        }
        
        visited.add(curr);
        
        for (int x: adj.getOrDefault(curr, new ArrayList<>())) {
            // If the edge we are about to follow is discarded, we do not
            // follow this edge.
            if (curr == discarded[0] && x == discarded[1]) {
                continue;
            }
            
            dfs(adj, x, discarded, visited);
        }
    }
}