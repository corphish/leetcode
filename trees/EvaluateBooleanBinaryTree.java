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
// https://leetcode.com/problems/evaluate-boolean-binary-tree 
class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        }

        if (root.val == 3) {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }

        return root.val == 1;
    }
}