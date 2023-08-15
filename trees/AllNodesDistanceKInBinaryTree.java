/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/ 
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        collect(graphOf(root), target, k, new HashSet<>(), res);
        return res;
    }

    void collect(
        Map<TreeNode, List<TreeNode>> adj, 
        TreeNode curr, 
        int dist,
        Set<TreeNode> visited,
        List<Integer> store
    ) {
        if (visited.contains(curr)) {
            return;
        }

        if (dist == 0) {
            store.add(curr.val);
            return;
        }

        if (adj.get(curr) == null) {
            return;
        }

        visited.add(curr);

        for (var node: adj.get(curr)) {
            collect(adj, node, dist - 1, visited, store);
        }

        visited.remove(curr);
    }

    Map<TreeNode, List<TreeNode>> graphOf(TreeNode root) {
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>();
        buildGraph(adj, root);
        return adj;
    }

    void buildGraph(Map<TreeNode, List<TreeNode>> adj, TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left != null) {
            adj.computeIfAbsent(root, x -> new ArrayList<>()).add(left);
            adj.computeIfAbsent(left, x -> new ArrayList<>()).add(root);
        }

        if (right != null) {
            adj.computeIfAbsent(root, x -> new ArrayList<>()).add(right);
            adj.computeIfAbsent(right, x -> new ArrayList<>()).add(root);
        }

        buildGraph(adj, left);
        buildGraph(adj, right);
    }
}