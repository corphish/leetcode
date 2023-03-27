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
// https://leetcode.com/problems/check-completeness-of-a-binary-tree/ 
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        boolean terminal = false;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node: queue) {
                if (terminal && node.left != null) {
                    return false;
                }
                if (node.right != null && node.left == null) {
                    return false;
                }
                if (node.right == null) {
                    terminal = true;
                }
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }

            queue.clear();
            queue.addAll(nextLevel);

            if (terminal) {
                for (TreeNode node: queue) {
                    if (node.left != null || node.right != null) {
                        return false;
                    }
                }

                return true;
            }
        }

        return true;
    }
}