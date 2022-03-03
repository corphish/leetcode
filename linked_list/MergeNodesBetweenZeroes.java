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
// https://leetcode.com/problems/merge-nodes-in-between-zeros
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode l = new ListNode(0), res = l, last = null;
        head = head.next;
        
        while (head != null) {
            if (head.val == 0) {
                l.next = new ListNode(0);
                last = l;
                l = l.next;
            } else {
                l.val += head.val;
            }
            
            head = head.next;
        }
        
        if (last != null)
            last.next = null;
        return res;
    }
}