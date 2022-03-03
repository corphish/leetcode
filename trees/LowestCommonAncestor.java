/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution for:
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        
        if (l != null) {
            return l;
        }
        
        if (r != null) {
            return r;
        }
        
        boolean x = search(root, p);
        boolean y = search(root, q);
        
        return x && y ? root : null;
    }
    
    boolean search(TreeNode root, TreeNode item) {
        if (root == null) return false;
        if (root == item) return true;
        
        return search(root.left, item) || search(root.right, item);
    }
}