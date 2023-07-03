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
// https://leetcode.com/problems/deepest-leaves-sum 
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int sum = 0;
        while (!q.isEmpty()) {
            Queue<TreeNode> temp = new ArrayDeque<>();
            sum = 0;
            while (!q.isEmpty()) {
                TreeNode t = q.poll();
                sum += t.val;
                if (t.left != null) temp.add(t.left);
                if (t.right != null) temp.add(t.right);
            }

            q = temp;
        }

        return sum;
    }
}