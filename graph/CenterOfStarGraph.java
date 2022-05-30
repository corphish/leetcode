// https://leetcode.com/problems/find-center-of-star-graph
class Solution {
    // All the edges will have a common node, that node is the answer.
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] count = new int[n + 1];
        for (int[] edge: edges) {
            if (++count[edge[0]] > 1) return edge[0];
            if (++count[edge[1]] > 1) return edge[1];
        }
        
        return n;
    }
}