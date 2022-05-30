// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
class Solution {
    // Solution is the list of nodes which has no incoming nodes.
    // In other words, the nodes are those which appear only in edges[i][0] and not in edges[i][1]
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] incoming = new int[n];
        
        for (var edge: edges) {
            incoming[edge.get(1)]++;
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (incoming[i] == 0) {
                res.add(i);
            }
        }
        
        return res;
    }
}