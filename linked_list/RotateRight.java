// https://leetcode.com/problems/rotate-list
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 0;
        
        ListNode res = null, h1 = head, h2 = head, prev = null;
        
        while (h1 != null) {
            len++;
            h1 = h1.next;
        }
        
        int point = k % len;
        if (point == 0) return head;            
        point = len - point;
        
        for (int i = 0; i < point; i++) {
            prev = h2;
            h2 = h2.next;
        }
        
        //System.out.printf("h2 = %d, head = %d, prev = %d\n", h2.val, head.val, prev.val);
        
        res = h2;
        
        while (h2.next != null) h2 = h2.next;
        
        h2.next = head;
        prev.next = null;
        
        return res;
    }
}