/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// https://leetcode.com/problems/delete-node-in-a-linked-list
class Solution {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        ListNode prev = null;
        while (node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        
        if (prev != null) prev.next = null;
    }
}