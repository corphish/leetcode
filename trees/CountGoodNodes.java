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
// https://leetcode.com/problems/count-good-nodes-in-binary-tree
class Solution {
    public int goodNodes(TreeNode root) {
        return traverse(root, Integer.MIN_VALUE);
    }
    
    public int traverse(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        
        int val = root.val >= max ? 1 : 0;
        int newMax = Math.max(max, root.val);
        
        return val + traverse(root.left, newMax) + traverse(root.right, newMax);
    }
}