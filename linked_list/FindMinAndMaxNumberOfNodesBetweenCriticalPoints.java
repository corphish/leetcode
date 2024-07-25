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
// https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points 
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null) return new int[] {-1, -1};
        ListNode prev = head;
        head = head.next;
        if (head == null && head.next == null) return new int[] {-1, -1};
        int index = 2;
        
        int minIndex = -1, maxIndex = -1, lastIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        
        while (head.next != null) {
            if ((head.val < prev.val && head.val < head.next.val) || (head.val > prev.val && head.val > head.next.val)) {
                if (minIndex == -1) {
                    minIndex = index;
                } else {
                    maxIndex = index;
                    minDistance = Math.min(index - lastIndex, minDistance);
                }
                lastIndex = index;
            }
            
            
            index++;

            prev = head;
            head = head.next;
        }
        
        return minIndex < 0 || maxIndex < 0 ? new int[] {-1, -1} : new int[] {minDistance, maxIndex - minIndex};
    }
}