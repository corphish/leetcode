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
// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/ 
class Solution {
    public int pairSum(ListNode head) {
        ListNode counter = head;
        int n = 0, i = 0, max = 0;
        while (counter != null) {
            n += 1;
            counter = counter.next;
        }

        int[] stack = new int[n/2];
        boolean stackFilled = false;
        while (head != null) {
            if (!stackFilled) {
                stack[i++] = head.val;
            } else {
                max = Math.max(max, head.val + stack[--i]);
            }

            if (i == stack.length) {
                stackFilled = true;
            }

            head = head.next;
        }

        return max;
    }
}