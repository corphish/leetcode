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
// https://leetcode.com/problems/reverse-linked-list/
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, temp = null;
        while (head != null) {
            // Store the next node in a variable because we are going to modify the head.next
            temp = head.next;
            
            // Modify the head.next to point to previous node
            head.next = prev;
            
            // Previous should now point to the current node, because in the next step we are going to point to this
            prev = head;
            
            // Advance the head with the original next node stored in temp
            head = temp;
        }
        
        return prev;
    }
}