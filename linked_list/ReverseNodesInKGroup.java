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
// https://leetcode.com/problems/reverse-nodes-in-k-group
class Solution {
    // Store the values in a stack, and for every k items added, build a new list by adding the same from stack.
    // Do not forget to check the stack state after the loop.
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = null, partPrev = null, prev = null;
        int n = k;
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            if (n != 0) {
                stack.add(head.val);
                n--;
            
                head = head.next;
            } else {
                ListNode part = null, point = null;
                
                while (!stack.isEmpty()) {
                    int x = stack.pollLast();
                    part = new ListNode(x);
                    if (point == null) point = part;
                    if (prev != null) prev.next = part;
                    prev = part;
                    part = part.next;
                }
                
                if (res == null) {
                    res = point;
                } else {
                    partPrev.next = point;
                }
                
                partPrev = prev;
                
                n = k;
            }
        }
        
        // At this point, n can be 0 meaning there is a pending reversal.
        
        if (!stack.isEmpty()) {
            ListNode part = null, point = null;
            prev = null;
            while (!stack.isEmpty()) {
                int x = n == 0 ? stack.pollLast() : stack.pollFirst() ;
                part = new ListNode(x);
                if (point == null) point = part;
                if (prev != null) prev.next = part;
                prev = part;
                part = part.next;
            }
            
            if (res == null) {
                res = point;
            } else
            if (partPrev != null) {
                partPrev.next = point;
            }
        }
        
        return res;
    }
}