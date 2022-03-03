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
// https://leetcode.com/problems/swap-nodes-in-pairs/
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode res = head, last = null, prev = null, t;
        boolean start = true;

        while (head != null) {
            // Alternatively track the last node.
            // For odd number of nodes visited, initially the last node is null, which is set to the head.
            // For even number of nodes visited, we perform the swap.
            // Logic for swapping is:
            //      When we are swapping for the first time:
            //          We keep track of the next of current head (that is the 3rd node) in some temp variable.
            //          We set the current head (2nd node) as resulting node.
            //          We set the next of current head as last (1st node).
            //          We keep track of the current 2nd node in a prev variable.
            //          We clear the last variable, indicating that we are done with the swap.
            //          We set the head to the temp variable, which is the next of the current head.
            //      When we are swapping not for the first time:
            //          We keep track of the next of current head (that is the 3rd node) in some temp variable.
            //          We set the prev node next as current variable (even node).
            //          We set the current head next (even node) as the last node.
            //          We set the next of the last node (the new even node) as the temp variable.
            //          We keep track of the current even node in a prev variable.
            //          We clear the last variable, indicating that we are done with the swap.
            //          We set the head to the temp variable, which is the next of the current head.
            if (last == null) {
                last = head;
                head = head.next;
            } else {
                if (start) {
                    t = head.next;
                    res = head;
                    head.next = last;
                    last.next = t;
                    start = false;
                    prev = last;
                    head = t;
                    last = null;
                } else {
                    t = head.next;
                    prev.next = head;
                    head.next = last;
                    last.next = t;
                    prev = last;
                    head = t;
                    last = null;
                }
            }
        }
        
        return res;
    }
}