/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// https://leetcode.com/problems/find-bottom-left-tree-value/
class Solution {
    int max = -1, res = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    int levelOrder(TreeNode root) {
        int left = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Deque<TreeNode> temp = new ArrayDeque<>();
            boolean leftChecked = false;
            while (!queue.isEmpty()) {
                TreeNode node = queue.removeFirst();
                if (!leftChecked) {
                    left = node.val;
                    leftChecked = true;
                }

                if (node.left != null)
                    temp.addLast(node.left);
                if (node.right != null)
                    temp.addLast(node.right);
            }

            queue = temp;
        }

        return left;
    }

    void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level > max) {
            max = level;
            res = root.val;
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}