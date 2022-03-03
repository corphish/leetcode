// https://leetcode.com/problems/binary-tree-postorder-traversal/submissions/
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        traverse(root, res);
        return res;
    }
    
    void traverse(TreeNode root, List<Integer> store) {
        if (root == null) return;
        traverse(root.left, store);
        traverse(root.right, store);
        store.add(root.val);
    }
}