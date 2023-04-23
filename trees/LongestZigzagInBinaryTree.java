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
// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree
class Solution {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }

        max(root.left, 0, 1);
        max(root.right, 1, 1);

        return max;
    }

    // dir: 0 - left, 1 - right
    // Dir indicates the direction of current node wrt previously traversed node
    void max(TreeNode root, int dir, int pathLen) {
        if (root == null) {
            return;
        }

        if (dir == 0) {
            // We are visiting root.left from previous call
            // Try to continue forming zigzag by going right
            if (root.right != null) {
                max(root.right, 1, pathLen + 1);
            } else {
                max = Math.max(max, pathLen);
            }

            // Consider current node as start of another zigzag
            // We can only go left now
            if (root.left != null) {
                max(root.left, 0, 1);
            }
        } else {
            // We are visiting root.right from previous call
            // Try to continue forming zigzag by going left
            if (root.left != null) {
                max(root.left, 0, pathLen + 1);
            } else {
                max = Math.max(max, pathLen);
            }

            // Consider current node as start of another zigzag
            // We can only go left now
            if (root.right != null) {
                max(root.right, 1, 1);
            }
        }
    }
}