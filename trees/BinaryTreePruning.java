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
// https://leetcode.com/problems/binary-tree-pruning
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        prune(root);
        
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        
        return root;
    }
    
    boolean prune(TreeNode root) {
        if (root == null) {
            return false;
        }
        
        boolean res = root.val == 1;
        
        boolean left = prune(root.left);
        boolean right = prune(root.right);
        
        if (!left) {
            root.left = null;
        }
        
        if (!right) {
            root.right = null;
        }
        
        return res || left || right;
    }
}