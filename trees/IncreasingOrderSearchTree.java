// https://leetcode.com/problems/increasing-order-search-tree
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
// In-order traversal to accumulate the values in a list.
// Then build the tree from the list
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> acc = new ArrayList<>();
        accumulate(root, acc);
        
        TreeNode res = new TreeNode(), prev = null, head = res;
        for (int x: acc) {
            res.val = x;
            res.right = new TreeNode();
            prev = res;
            res = res.right;
        }
        
        prev.right = null;
        return head;
    }
    
    void accumulate(TreeNode root, List<Integer> acc) {
        if (root == null) {
            return;
        }
        
        accumulate(root.left, acc);
        acc.add(root.val);
        accumulate(root.right, acc);
    }
}