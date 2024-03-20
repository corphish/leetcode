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
// https://leetcode.com/problems/merge-in-between-linked-lists 
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = null, end = null;
        int count = 0;
        ListNode res = list1;
        while (count <= b && list1 != null) {
            if (count < a) {
                start = list1;
            } else if (count == b) {
                end = list1.next;
            }

            count += 1;
            list1 = list1.next;
        }

        if (start == null) {
            start = list2;
            res = start;
        } else {
            start.next = list2;
        }

        while (list2.next != null) {
            list2 = list2.next;
        }

        list2.next = end;
        return res;
    }
}