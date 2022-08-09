/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree
class Solution {
    // Perform any traversal on cloned, and if cloned.val == target.val return the cloned.
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null) {
            return null;
        }
        
        if (cloned.val == target.val) {
            return cloned;
        }
        
        TreeNode left = getTargetCopy(original, cloned.left, target);
        TreeNode right = getTargetCopy(original, cloned.right, target);
        
        if (left != null) {
            return left;
        }
        
        if (right != null) {
            return right;
        }
        
        return null;
    }
}