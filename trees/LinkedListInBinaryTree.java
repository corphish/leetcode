/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
// https://leetcode.com/problems/linked-list-in-binary-tree 
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return checkEach(root, head);
    }

    boolean checkEach(TreeNode root, ListNode head) {
        if (root == null) {
            return false;
        }

        boolean res = false;
        if (root.val == head.val) {
            res = check(root, head, head);
        }

        return res || checkEach(root.left, head) || checkEach(root.right, head);
    }

    boolean check(TreeNode root, ListNode head, ListNode curr) {
        if (curr == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (root.val == curr.val && head != curr) {
            return check(root.left, head, curr.next) || check(root.right, head, curr.next);
        }

        if (root.val == head.val) {
            return check(root.left, head, head.next) || check(root.right, head, head.next);
        }

        return check(root.left, head, head) || check(root.right, head, head);
    }
}