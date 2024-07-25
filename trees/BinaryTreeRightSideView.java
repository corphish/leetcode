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
// https://leetcode.com/problems/binary-tree-right-side-view 
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<TreeNode> temp = new ArrayList<>();

        if (root == null) {
            return res;
        }

        queue.add(root);
        res.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode last = null;
            temp.clear();

            while (!queue.isEmpty()) {
                TreeNode t = queue.pollFirst();
                
                if (t.left != null) {
                    last = t.left;
                    temp.add(t.left);
                }

                if (t.right != null) {
                    last = t.right;
                    temp.add(t.right);
                }
            }

            queue.addAll(temp);

            if (last != null) {
                res.add(last.val);
            }
        }

        return res;
    }
}