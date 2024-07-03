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
// https://leetcode.com/problems/smallest-string-starting-from-leaf/ 
class Solution {
    String min = "";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return min;
    }

    void dfs(TreeNode root, String x) {
        if (root == null) {
            return;
        }

        String k = ((char) (root.val + 'a')) + x;

        if (root.left == null && root.right == null) {
            if (min.equals("") || k.compareTo(min) < 0) {
                min = k;
            }
        } else {
            dfs(root.left, k);
            dfs(root.right, k);
        }
    }
}