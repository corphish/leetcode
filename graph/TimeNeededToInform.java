// https://leetcode.com/problems/time-needed-to-inform-all-employees
class Solution {
    // Build a directed graph using the manager array.
    // Perform dfs on the graph and calculate the max time taken to reach a leaf node.
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                List<Integer> list = adj.getOrDefault(manager[i], new ArrayList<>());
                list.add(i);
                adj.put(manager[i], list);
            }
        }
        
        //System.out.println(adj);
        
        return dfs(adj, headID, informTime);
    }
    
    int dfs(Map<Integer, List<Integer>> adj, int curr, int[] informTime) {
        if (!adj.containsKey(curr)) {
            return 0;
        }
        
        int max = 0;
        
        for (int neighbor: adj.get(curr)) {
            int timeTaken = informTime[curr] + dfs(adj, neighbor, informTime);
            max = Math.max(max, timeTaken);
        }
        
        return max;
    }
}