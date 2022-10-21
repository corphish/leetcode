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
// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree
class Solution {
    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Average avg = new Average();
        dfs(root, avg);
        
        int res = avg.get() == root.val ? 1 : 0;
        return res + averageOfSubtree(root.left) + averageOfSubtree(root.right);
    }
    
    void dfs(TreeNode root, Average avg) {
        if (root == null) {
            return;
        }
        
        avg.track(root.val);
        dfs(root.left, avg);
        dfs(root.right, avg);
    }
    
    class Average {
        int sum, n;
        
        void track(int x) {
            sum += x;
            n++;
        }
        
        int get() {
            return n == 0 ? 0 : sum/n;
        }
    }
}