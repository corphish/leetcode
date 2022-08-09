// https://leetcode.com/problems/binary-tree-level-order-traversal
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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        
        if (root == null) {
            return res;
        }
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Deque<TreeNode> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                temp.addLast(queue.poll());
            }
            
            List<Integer> level = new ArrayList<>();
            for (TreeNode t: temp) {
                level.add(t.val);
                
                if (t.left != null) {
                    queue.add(t.left);
                }
                
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            
            res.add(level);
        }
        
        return res;
    }
}