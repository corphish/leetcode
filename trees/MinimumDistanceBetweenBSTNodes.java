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
// https://leetcode.com/problems/minimum-distance-between-bst-nodes/ 
class Solution {
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        collect(root, list);

        int min = Integer.MAX_VALUE, last = min;
        for (int x: list) {
            if (last == Integer.MAX_VALUE) {
                last = x;
            } else {
                min = Math.min(min, x - last);
                last = x;
            }
        }

        return min;
    }

    void collect(TreeNode root, List<Integer> list) {
        if (root == null) return;

        collect(root.left, list);
        list.add(root.val);
        collect(root.right, list);
    }
}