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
// https://leetcode.com/problems/kth-smallest-element-in-a-bst
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = inorderTraversal(root);
        return res.get(k - 1);
    }
    
    private List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        if (res == null) {
            res = new ArrayList<>();
        }
        
        if (root == null) {
            return res;
        }
        
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        
        return res;
    }
}