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
// https://leetcode.com/problems/even-odd-tree
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            Deque<TreeNode> temp = new ArrayDeque<>();
            int last = -1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.removeFirst();
                int x = node.val;
                if (last == -1) {
                    if (x % 2 == level % 2) {
                        last = x;
                    } else {
                        return false;
                    }
                } else {
                    if (x % 2 == level % 2) {
                        if (level % 2 == 1 && x <= last) {
                            return false;
                        }
                        if (level % 2 == 0 && x >= last) {
                            return false;
                        }
                        last = x;
                    } else {
                        return false;
                    }
                }

                if (node.left != null)
                    temp.addLast(node.left);
                if (node.right != null)
                    temp.addLast(node.right);
            }

            queue = temp;
            level += 1;
        }

        return true;
    }
}