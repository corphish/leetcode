// https://leetcode.com/problems/course-schedule-iv
class Solution {
    // Build a directed graph and represent it as adjacency list.
    // An edge will exist from node A to node B if A is pre-requisite of B.
    // Now for each query, check if there is a path from x1 to x2 using DFS.
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int[] req: prerequisites) {
            List<Integer> l = adj.getOrDefault(req[0], new ArrayList<>());
            l.add(req[1]);
            adj.put(req[0], l);
        }
        
        List<Boolean> res = new ArrayList<>();
        for (int[] q: queries) {
            boolean[] visited = new boolean[n];
            res.add(hasPath(adj, q[0], q[1], visited));
        }
        
        return res;
    }
    
    boolean hasPath(
        Map<Integer, List<Integer>> adj, 
        int src, int dest, 
        boolean[] visited
    ) {
        if (src == dest) return true;
        
        visited[src] = true;
        
        for (int x: adj.getOrDefault(src, List.of())) {
            if (!visited[x]) {
                boolean res = hasPath(adj, x, dest, visited);
                if (res) {
                    return true;
                }
            }
        }
        
        return false;
    }
}