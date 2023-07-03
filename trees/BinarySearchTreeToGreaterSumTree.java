/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree 
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        List<Integer> collect = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        dfs(root, collect, null);
        int cum = 0, last = -1;
        for (int i = collect.size() - 1; i >= 0; i--) {
            int x = collect.get(i);
            if (x != last) {
                map.put(x, cum);
            }

            cum += x;
            last = x;
        }

        dfs(root, collect, map);
        return root;
    }

    void dfs(TreeNode root, List<Integer> collect, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        if (map == null) {
            dfs(root.left, collect, map);
            collect.add(root.val);
            dfs(root.right, collect, map);
        } else {
            root.val += map.get(root.val);
            dfs(root.left, collect, map);
            dfs(root.right, collect, map);
        }
    }
}