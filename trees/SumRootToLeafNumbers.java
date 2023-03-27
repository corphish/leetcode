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
// https://leetcode.com/problems/sum-root-to-leaf-numbers 
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    public int sumNumbers(TreeNode root, int acc) {
        if (root == null) {
            return 0;
        }
        
        int v = acc * 10 + root.val;
        if (root.left == null && root.right == null) {
            return v;
        }
        
        return sumNumbers(root.left, v) + sumNumbers(root.right, v);
    }
}