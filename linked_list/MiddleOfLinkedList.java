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
// https://leetcode.com/problems/middle-of-the-linked-list 
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode res = head;
        while (head != null) {
            head = head.next;
            if (head != null) {
                head = head.next;
                res = res.next;
            }
        }
        
        return res;
    }
}