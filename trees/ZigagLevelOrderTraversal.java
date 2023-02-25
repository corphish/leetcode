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
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/ 
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        int flag = 1;
        queue.add(root);

        while (!queue.isEmpty()) {
            List<TreeNode> children = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.removeFirst();
                list.add(node.val);

                if (node.left != null)
                    children.add(node.left);

                if (node.right != null)
                    children.add(node.right);    
            }

            queue.addAll(children);

            if (flag == -1) {
                Collections.reverse(list);
            }

            res.add(list);
            flag = -flag;
        }

        return res;
    }
}