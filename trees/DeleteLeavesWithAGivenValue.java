// https://leetcode.com/problems/delete-leaves-with-a-given-value
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return delete(root, null, true, target) ? root : null;
    }

    boolean delete(TreeNode root, TreeNode parent, boolean isLeft, int target) {
        if (root == null) {
            return true;
        }

        delete(root.left, root, true, target);
        delete(root.right, root, false, target);

        if (root.val == target && root.left == null && root.right == null) {
            if (parent == null)
                return false;

            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        return true;
    }
}