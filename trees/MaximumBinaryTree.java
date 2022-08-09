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
// https://leetcode.com/problems/maximum-binary-tree
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);    
    }
    
    // End exclusive
    TreeNode construct(int[] nums, int start, int end) {
        //System.out.println(start + " " + end);
        if (start >= end) return null;
        
        // Important that we keep default index as start
        // Otherwise if max is 0, index will remain 0 (if initialized with 0), which
        // may not be correct if start != 0.
        int max = 0, index = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        
        TreeNode t = new TreeNode(max);
        t.left = construct(nums, start, index);
        t.right = construct(nums, index + 1, end);
        
        return t;
    }
}