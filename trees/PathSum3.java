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
// https://leetcode.com/problems/path-sum-iii 
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int count = sum(root, targetSum);
        return count + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    int sum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        int x = 0;
        if (targetSum == root.val) {
            x = 1;
        }

        int count = 
            // Continue on this node
            x + sum(root.left, targetSum - root.val) + sum(root.right, targetSum - root.val);

        return count;
    }
}