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
// https://leetcode.com/problems/palindrome-linked-list/
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head, nHead = head, p2 = head, prev = null;
        int n = 0;
        
        while (nHead != null) {
            nHead = nHead.next;
            if (nHead != null) {
                nHead = nHead.next;
            }
            
            p2 = p2.next;
        }
        
        // Reverse from p2
        ListNode t = p2;
        while (t != null) {
            if (prev != null) {
                ListNode temp = t.next;
                t.next = prev;
                prev = t;
                t = temp;
            } else {
                prev = t;
                t = t.next;
            }
            
            n++;
        }
        
        p2 = prev;
        while (n-- > 0) {
            if (p1.val != p2.val) {
                return false;
            }
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return true;
    }
}