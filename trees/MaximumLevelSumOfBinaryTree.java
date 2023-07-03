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
// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree 
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        int level = 1, max = Integer.MIN_VALUE, res = 0;

        q.add(root);
        while (!q.isEmpty()) {
            int sum = 0;
            Queue<TreeNode> temp = new ArrayDeque<>();

            while (!q.isEmpty()) {
                TreeNode t = q.poll();
                sum += t.val;
                if (t.left != null) temp.add(t.left);
                if (t.right != null) temp.add(t.right);
            }

            if (sum > max) {
                max = sum;
                res = level;
            }

            q = temp;
            level += 1;
        }

        return res;
    }
}