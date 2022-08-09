// https://leetcode.com/problems/remove-duplicates-from-sorted-list
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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head, last = null;
        
        while (head != null) {
            if (last == null) {
                last = head;
            } else {
                if (head.val > last.val) {
                    last.next = head;
                    last = head;
                }
            }
            
            head = head.next;
        }
        
        if (last != null)
            last.next = null;
        
        return res;
    }
}