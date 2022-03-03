/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// https://leetcode.com/problems/linked-list-cycle
public class Solution {
    // My solution: If there is a loop, the count will be greater than the max possible length of the list.
    // This is not a good solution. See below for a better solution.
    public boolean hasCycleInEff(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            if (++count > 10000) return true;
        }
        
        return false;
    }

    // We are incrementing slow by one and fast by two. 
    // If linked list doesn't have cycle, the fast will reach null and return false. 
    // But if at some point fast equals slow, this means it does have a cycle and return true.
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}