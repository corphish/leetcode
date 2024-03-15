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
// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected 
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> adj = graphOf(root);
        Set<Integer> infected = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int mins = -1;

        queue.addLast(start);
        while (!queue.isEmpty()) {
            Deque<Integer> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                int head = queue.pollFirst();
                if (!infected.add(head)) {
                    continue;
                }

                List<Integer> neighbors = adj.get(head);
                if (neighbors == null) continue;
                for (int node: neighbors) {
                    if (!infected.contains(node))
                        temp.addLast(node);
                }
            }

            queue = temp;
            mins += 1;
        }

        return mins;
    }

    Map<Integer, List<Integer>> graphOf(TreeNode root) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        if (root != null) {
            queue.addLast(root);
        }

        while (!queue.isEmpty()) {
            TreeNode head = queue.pollFirst();
            TreeNode left = head.left;
            TreeNode right = head.right;

            if (left != null) {
                adj.computeIfAbsent(head.val, x -> new ArrayList<>()).add(left.val);
                adj.computeIfAbsent(left.val, x -> new ArrayList<>()).add(head.val);
                queue.addLast(left);
            }

            if (right != null) {
                adj.computeIfAbsent(head.val, x -> new ArrayList<>()).add(right.val);
                adj.computeIfAbsent(right.val, x -> new ArrayList<>()).add(head.val);
                queue.addLast(right);
            }
        }

        return adj;
    }
}