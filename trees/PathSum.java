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
// https://leetcode.com/problems/path-sum
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return sum(root, targetSum, 0);
    }
    
    private boolean sum(TreeNode root, int target, int acc) {
        if (root == null) {
            return acc == target;
        }
        
        
        if (root.left == null && root.right == null) {
            return (acc + root.val) == target;
        }
        
        return (root.left != null ? sum(root.left, target, acc + root.val) : false) || (root.right != null ? sum(root.right, target, acc + root.val) : false);
    }
}