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
// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
class Solution {
    public int maxProduct(TreeNode root) {
        MaxTracker tracker = new MaxTracker(totalSum(root));
        maxProduct(root, tracker);
        return tracker.getMax();
    }

    int totalSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + totalSum(root.left) + totalSum(root.right);
    }

    int maxProduct(TreeNode root, MaxTracker tracker) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            tracker.test(root.val);
            return root.val;
        }

        int subtreeSum = maxProduct(root.left, tracker) + maxProduct(root.right, tracker) + root.val;
        tracker.test(subtreeSum);

        return subtreeSum;
    }

    class MaxTracker {
        final int totalSum;
        long max;

        MaxTracker(int totalSum) {
            this.totalSum = totalSum;
        }

        void test(int sum) {
            int rem = totalSum - sum;
            long product = 1L * sum * rem;
            max = Math.max(max, product);
        }

        int getMax() {
            return (int) (max % 1000000007);
        }
    }
}