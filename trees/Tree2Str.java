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
// https://leetcode.com/problems/construct-string-from-binary-tree
class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        return (root.left == null && root.right == null ? "" + root.val : root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")").replace("())", ")").replace(")()", ")");
    }
}