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
// https://leetcode.com/problems/reverse-linked-list
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode last = null, t = null;
        while (head.next != null) {
            if (last != null) {
                // last=2, head=3, t=3, head.next=1
                t = head.next;
                head.next = last;
                last = head;
                head = t;
            } else {
                last = head;
                head = head.next;
                last.next = null;
            }
        }
        
        head.next = last;
        
        return head;
    }
}