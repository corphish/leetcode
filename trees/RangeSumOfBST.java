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
 // https://leetcode.com/problems/range-sum-of-bst
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int x = root.val >= low && root.val <= high ? root.val : 0;
        
        return x + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}