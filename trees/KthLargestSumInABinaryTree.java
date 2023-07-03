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
// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree 
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<Long> sums = new ArrayList<>();

        q.add(root);
        while (!q.isEmpty()) {
            long sum = 0;
            Queue<TreeNode> temp = new ArrayDeque<>();

            while (!q.isEmpty()) {
                TreeNode t = q.poll();
                sum += t.val;
                if (t.left != null) temp.add(t.left);
                if (t.right != null) temp.add(t.right);
            }

            sums.add(sum);
            q = temp;
        }

        Collections.sort(sums);
        return k > sums.size() ? -1 : sums.get(sums.size() - k);
    }
}