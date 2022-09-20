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
// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[10];
        return count(root, freq);
    }
    
    int count(TreeNode root, int[] freq) {
        if (root == null) {
            return 0;
        }
        
        freq[root.val]++;
        
        if (root.left == null && root.right == null) {
            //System.out.println("Analysing " + Arrays.toString(freq));
            int oddCount = 0;
            for (int x: freq) {
                oddCount += x % 2;
            }
            
            freq[root.val]--;
            
            return oddCount < 2 ? 1 : 0;
        } else {
            int res = count(root.left, freq) + count(root.right, freq);
            freq[root.val]--;
            return res;
        }
    }
}