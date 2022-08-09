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
// https://leetcode.com/problems/remove-nth-node-from-end-of-list
class Solution {
    // 1. Maintain 2 pointers
    //    - Increment 1 pointer as you normally would.
    //    - For the other pointer, initialize it with null.
    //    - Under each iteration, if n >= 1, decrease n by 1, if n == 0, assign the second pointer to be the head of input.
    //    - When n is 0, increase the 2nd pointer normally.
    // 2. We now have to work with 2nd pointer.
    //    - If it is null, we have to delete 1st item, so return res.next (where res is the head of original input).
    //    - If not, check if p1.next is null or not, if null then p1.next = null else p1.next = p1.next.next.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = head, p1 = null;
        while (head != null) {
            if (n >= 1) {
                n--;
            } else if (n == 0) {
                p1 = res;
                n--;
            } else {
                p1 = p1.next;
            }
            
            head = head.next;
        }
        
        // This happens only when we want to delete 1st item in list
        if (p1 == null) {
            return res.next;
        }
        
        // We have to delete the p1.next and attach p1.next = p1.next.next
        if (p1.next != null) {
            p1.next = p1.next.next;
        } else {
            p1.next = null;
        }
        
        return res;
    }
}