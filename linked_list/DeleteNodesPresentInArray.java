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
// https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array 
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int x: nums) {
            set.add(x);
        }

        ListNode res = null, prev = null;
        while (head != null) {
            if (!set.contains(head.val)) {
                if (prev == null) {
                    prev = head;
                } else {
                    prev.next = head;
                    prev = prev.next;
                }

                if (res == null) {
                    res = head;
                }
            }

            head = head.next;
        }

        prev.next = null;

        return res;
    }
}