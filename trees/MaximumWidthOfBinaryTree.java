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
// https://leetcode.com/problems/maximum-width-of-binary-tree 
// No other way than manually indexing each node.
// index of node.left = 2 * index of current node + 1
// index of node.right = 2 * index of current node + 2
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        IndexedNode indexedRoot = new IndexedNode(0, root);
        Deque<IndexedNode> queue = new ArrayDeque<>();
        queue.add(indexedRoot);

        long max = 1;

        while (!queue.isEmpty()) {
            long left = queue.peekFirst().index;
            long right = queue.peekFirst().index;

            Deque<IndexedNode> temp = new ArrayDeque<>();
            for (IndexedNode node: queue) {
                left = Math.min(node.index, left);
                right = Math.max(node.index, right);

                if (node.node.left != null) {
                    temp.add(new IndexedNode(2 * node.index + 1, node.node.left));
                }

                if (node.node.right != null) {
                    temp.add(new IndexedNode(2 * node.index + 2, node.node.right));
                }
            }

            max = Math.max(max, right - left + 1);
            queue = temp;
        }

        return (int) max;
    }

    class IndexedNode {
        long index = 0;
        TreeNode node;

        IndexedNode(long index, TreeNode node) {
            this.index = index;
            this.node = node;
        }

        public String toString() {
            return "(index=" + index + ", val=" + node.val + ")";
        }
    }
}