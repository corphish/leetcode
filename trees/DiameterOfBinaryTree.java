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
// https://leetcode.com/problems/diameter-of-binary-tree/ 
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        int left = lengthTillLeaf(root.left);
        int right = lengthTillLeaf(root.right);

        return Math.max(
            left + right, 
            Math.max(
                diameterOfBinaryTree(root.left),
                diameterOfBinaryTree(root.right)
            )
        );
    }

    int lengthTillLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(lengthTillLeaf(root.left), lengthTillLeaf(root.right));
    }
}