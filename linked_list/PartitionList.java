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
// https://leetcode.com/problems/partition-list 
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode first = null, last = null, lastStart = null, res = null;
        while (head != null) {
            if (head.val < x) {
                if (first == null) {
                    first = new ListNode(head.val);
                    res = first;
                } else {
                    first.next = new ListNode(head.val);
                    first = first.next;
                }   
            } else {
                if (last == null) {
                    last = new ListNode(head.val);
                    lastStart = last;
                } else {
                    last.next = new ListNode(head.val);
                    last = last.next;
                }
            }

            head = head.next;
        }

        if (first != null) {
            first.next = lastStart;
        } else {
            res = lastStart;
        }

        return res;
    }
}