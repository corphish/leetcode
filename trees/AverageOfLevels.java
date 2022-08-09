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
// https://leetcode.com/problems/average-of-levels-in-binary-tree/
class Solution {
    // Do a BFS, but during each iteration, empty the queue totally,
    // adding its children in a new queue and using that queue further.
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Deque<TreeNode> newQueue = new ArrayDeque<>();
            
            double sum = 0;
            int count = 0;
            
            while (!queue.isEmpty()) {
                TreeNode first = queue.pollFirst();
                
                sum += first.val;
                count++;
                
                if (first.left != null){
                    newQueue.add(first.left);
                } 
                
                if (first.right != null){
                    newQueue.add(first.right);
                }
            }
            
            res.add(sum/count);
            
            queue = newQueue;
        }
        
        return res;
    }
}