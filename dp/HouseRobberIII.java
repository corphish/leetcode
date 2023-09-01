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
// https://leetcode.com/problems/house-robber-iii 
class Solution {
    public int rob(TreeNode root) {
        return max(root, false, new HashMap<>());
    }

    int max(TreeNode root, boolean skip, Map<Pair<TreeNode, Boolean>, Integer> memo) {
        if (root == null) {
            return 0;
        }

        Pair<TreeNode, Boolean> p = new Pair<>(root, skip);

        if (memo.containsKey(p)) {
            return memo.get(p);
        }

        if (skip) {
            return max(root.left, false, memo) + max(root.right, false, memo);
        }

        // We can now choose to skip this or not
        int res = Math.max(
            root.val + max(root.left, true, memo) + max(root.right, true, memo),
            max(root.left, false, memo) + max(root.right, false, memo)
        );

        memo.put(p, res);
        return res;
    }
}