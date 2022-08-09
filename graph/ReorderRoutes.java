// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
class Solution {
    // Although the input is directed graph, if we consider the graph to be undirected, there will always be 
    // full DFS traversal from node 0.
    // So we do that, and if we encounter a travel that is actually present in the directed graph, and the
    // incident node is not already visited, we reverse them.
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> unAdj = new HashMap<>();
        Map<Integer, Set<Integer>> dirAdj = new HashMap<>();
        
        for (int[] dir: connections) {
            unAdj.computeIfAbsent(dir[0], k -> new ArrayList<>()).add(dir[1]);
            unAdj.computeIfAbsent(dir[1], k -> new ArrayList<>()).add(dir[0]);
            dirAdj.computeIfAbsent(dir[0], k -> new HashSet<>()).add(dir[1]);
        }
        
        Set<String> reversed = new HashSet<>();
        dfs(unAdj, dirAdj, 0, new HashSet<>(), reversed);
        
        //System.out.println(reversed);
        
        return reversed.size();
    }
    
    void dfs(
        Map<Integer, List<Integer>> unAdj,
        Map<Integer, Set<Integer>> dirAdj,
        int curr,
        Set<Integer> visited,
        Set<String> reversed
    ) {
        if (visited.contains(curr)) {
            return;
        }
        
        visited.add(curr);
        
        for (int x: unAdj.getOrDefault(curr, new ArrayList<>())) {
            if (dirAdj.getOrDefault(curr, Set.of()).contains(x) && !visited.contains(x)) {
                reversed.add(curr + " -> " + x);
            }
            
            dfs(unAdj, dirAdj, x, visited, reversed);
        }
    }
}