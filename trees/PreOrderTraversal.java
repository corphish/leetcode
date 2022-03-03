// https://leetcode.com/problems/binary-tree-preorder-traversal/
class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        traverse(root, res);
        return res;
    }
    
    void traverse(TreeNode root, List<Integer> store) {
        if (root == null) return;
        store.add(root.val);
        traverse(root.left, store);
        traverse(root.right, store);
    }
}