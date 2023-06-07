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
// https://leetcode.com/problems/cousins-in-binary-tree 
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        return depthOf(root, x) == depthOf(root, y) && parentOf(root, x) != parentOf(root, y);
    }

    int depthOf(TreeNode root, int x) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if (root.val == x) {
            return 1;
        }

        return 1 + Math.max(depthOf(root.left, x), depthOf(root.right, x));
    }

    int parentOf(TreeNode root, int x) {
        if (root == null) {
            return -1;
        }

        if (root.left != null && root.left.val == x) {
            return root.val;
        }

        if (root.right != null && root.right.val == x) {
            return root.val;
        }

        return Math.max(parentOf(root.left, x), parentOf(root.right, x));
    }
}