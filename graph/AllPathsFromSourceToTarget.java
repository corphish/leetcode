// https://leetcode.com/problems/all-paths-from-source-to-target
class Solution {
    // Starting with i = 0, we have to recursively travel all of its neighbors
    // and keep track of the path.
    // We will accumulate the path in a result list when we reach n - 1 node.
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        travel(graph, 0, graph.length, new Stack<>(), res);
        return res;
    }
    
    void travel(int[][] graph, int curr, int n, Stack<Integer> path, List<List<Integer>> res) {
        path.push(curr);
        if (curr == n - 1) {
            res.add(new ArrayList<>(path));
            path.pop();
            return;
        }
        
        for (int neighbor: graph[curr]) {
            travel(graph, neighbor, n, path, res);
        } 
        
        path.pop();
    }
}