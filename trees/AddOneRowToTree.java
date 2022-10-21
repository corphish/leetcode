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
// https://leetcode.com/problems/add-one-row-to-tree
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode t = new TreeNode(val);
            t.left = root;
            return t;
        } else {
            addRow(root, val, depth);
            return root;
        }
    }
    
    void addRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return;
        }
        if (depth == 2) {
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            
            left.left = root.left;
            right.right = root.right;
            
            root.left = left;
            root.right = right;
        } else {
            addRow(root.left, val, depth - 1);
            addRow(root.right, val, depth - 1);
        }
    }
}