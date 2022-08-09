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
// https://leetcode.com/problems/delete-leaves-with-a-given-value
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return delete(root, null, true, target) ? root : null;
    }
    
    // In order to delete a node, we have to set the parent.left = null if the node that
    // we are trying to delete is parent's left, and the vice versa for right.
    // So we keep track of the parent as well as the fact whether the root that we have is
    // parent's left child or right child.
    // Edge case is when we have to delete parent. In this case we have to return null from the main function
    // as this case will only happen when all the nodes needs to be deleted.
    // So there has to be a way for this function to tell the main function to return null.
    // We use boolean, we return true if root needs to be returned, false if null needs to be returned.
    boolean delete(TreeNode root, TreeNode parent, boolean isLeft, int target) {
        if (root == null) {
            return true;
        }
        
        delete(root.left, root, true, target);
        delete(root.right, root, false, target);
        
        if (root.val == target && root.left == null && root.right == null) {
            if (parent == null) return false;
            
            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        
        return true;
    }
}