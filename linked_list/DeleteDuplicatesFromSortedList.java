// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
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
        ListNode res = null, temp = head, last = null;
        int[] freq = new int[202];
        
        
        while (head != null) {
            freq[head.val + 100]++;            
            head = head.next;
        }
        
        head = temp;
        while (head != null) {
            if (freq[head.val + 100] == 1) {
                if (res == null) {
                    res = head;
                    last = head;
                } else {
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