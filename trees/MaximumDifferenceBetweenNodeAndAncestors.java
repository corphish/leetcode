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
 // https://leetcode.com/problems/maximum-difference-between-node-and-ancestor
 class Solution {
    public int maxAncestorDiff(TreeNode root) {
        ValueTracker tracker = new ValueTracker();
        dfs(root, tracker);
        return tracker.maxDiff;
    }

    void dfs(TreeNode root, ValueTracker tracker) {
        if (root == null) {
            return;
        }

        tracker.track(root.val);
        dfs(root.left, tracker);
        dfs(root.right, tracker);
        tracker.untrack(root.val);
    }

    class ValueTracker {
        Stack<Integer> maxStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        int maxDiff = 0;

        ValueTracker() {
            
        }

        void track(int x) {
            if (maxStack.isEmpty() || x >= maxStack.peek()) {
                maxStack.push(x);
            }

            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }

            maxDiff = Math.max(maxDiff, maxStack.peek() - minStack.peek());
        }

        void untrack(int x) {
            if (x == maxStack.peek()) {
                maxStack.pop();
            }

            if (x == minStack.peek()) {
                minStack.pop();
            }
        }

        public String toString() {
            return "max = " + maxStack + ", min = " + minStack;
        }
    }
}