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
// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/ 
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode res = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        boolean del = false;
        while (head != null) {
            sum += head.val;
            if (sum == 0) {
                res = head.next;
                del = true;
            } else if (map.containsKey(sum)) {
                map.get(sum).next = head.next;
                del = true;
            } else {
                map.put(sum, head);
            }

            head = head.next;
        }

        return del ? removeZeroSumSublists(res) : res;
    }
}