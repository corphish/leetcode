// https://leetcode.com/problems/flip-equivalent-binary-trees 
class Solution {
    public boolean flipEquiv(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        return (flipEquiv(a.left, b.left) && flipEquiv(a.right, b.right))
                || (flipEquiv(a.left, b.right) && flipEquiv(a.right, b.left));
    }
}