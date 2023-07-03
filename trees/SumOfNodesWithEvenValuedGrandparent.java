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
// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent 
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, false);
    }

    int dfs(TreeNode root, boolean even) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (even) {
            sum += root.left == null ? 0 : root.left.val;
            sum += root.right == null ? 0 : root.right.val;
        }

        return sum + dfs(root.left, root.val % 2 == 0) +
            dfs(root.right, root.val % 2 == 0);
    }
}