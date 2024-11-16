// https://leetcode.com/problems/cousins-in-binary-tree-ii 
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Map<Integer, Integer> sum = new HashMap<>();
        Map<TreeNode, Integer> childSum = new HashMap<>();

        traverse(root, 0, sum, childSum);
        update(root, null, 0, sum, childSum);

        return root;
    }

    void traverse(
        TreeNode root,
        int depth,
        Map<Integer, Integer> sum,
        Map<TreeNode, Integer> childSum
    ) {
        if (root == null) {
            return;
        }

        sum.put(depth, sum.getOrDefault(depth, 0) + root.val);
        int x = 0;

        if (root.left != null) {
            x += root.left.val;
        }

        if (root.right != null) {
            x += root.right.val;
        }

        childSum.put(root, x);

        traverse(root.left, depth + 1, sum, childSum);
        traverse(root.right, depth + 1, sum, childSum);
    }

    void update(
        TreeNode root,
        TreeNode parent,
        int depth,
        Map<Integer, Integer> sum,
        Map<TreeNode, Integer> childSum
    ) {
        if (root == null) {
            return;
        }

        if (parent == null) {
            root.val = 0;
        } else {
            root.val = sum.get(depth) - childSum.get(parent);
        }

        update(root.left, root, depth + 1, sum, childSum);
        update(root.right, root, depth + 1, sum, childSum);
    }
}