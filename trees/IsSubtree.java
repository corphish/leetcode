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
// https://leetcode.com/problems/subtree-of-another-tree
class Solution {
    // If the value of a node in root matches with the value of root node of subroot, proceed with checking that node whether it matches with subroot or not.
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        
        boolean res = false;
        
        if (root.val == subRoot.val) {
            res = check(root, subRoot);
        }
        
        return res || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); 
    }
    
    // 1. If both t1 and t2 are null, return true.
    // 2. If any one of them is null and the other one is not null, return false;
    // 3. If values dont match return false.
    // 4. Check the left and right of each tree recursively.
    boolean check(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        
        if (t1 == null && t2 != null) {
            return false;
        }
        
        if (t1 != null && t2 == null) {
            return false;
        }
        
        if (t1.val != t2.val) {
            return false;
        }
        
        return check(t1.left, t2.left) && check(t1.right, t2.right);
    }
}