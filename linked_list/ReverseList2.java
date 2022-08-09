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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // We need 3 nodes from the portion of the list that is unreversed
        // 1. Head (res)
        // 2. The node before the starting point of reversal (start)
        // 3. The node after the ending point of reversal (end)
        
        // head -> start -> prev -> end
        ListNode res = head, start = head, end = null;
        int i = 0;
        
        // For reversal
        ListNode prev = null, temp = null, revFirst = null;
        while (head != null) {
            if (i >= left - 1 && i <= right - 1) {
                // But in this case we have to store the first node so that we connect it with
                // the remaining unreversed node
                if (prev == null) {
                    revFirst = head;
                }
                
                // Normal reversal logic
                temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
            } else if (i < left) {
                // Find the last node before reversal
                start = head;
                head = head.next;
            } else if (i >= right && end == null) {
                // Find the first node after reversal
                end = head;
                head = head.next;
            } else {
                head = head.next;
            }
            
            i++;
        }
        
        // Start should point to head of the reversed linked list
        start.next = prev;
        
        // Revfirst should point to the end
        revFirst.next = end;
        
        // If left is one, the head changes, so we return prev, else res
        return left == 1 ? prev : res;
    }
}