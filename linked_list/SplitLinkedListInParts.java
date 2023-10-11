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
// https://leetcode.com/problems/split-linked-list-in-parts 
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode count = head;
        ListNode[] res = new ListNode[k];
        int n = 0;
        int eq = 0, bal = 0;

        while (count != null) {
            count = count.next;
            n += 1;
        }

        eq = n/k;
        bal = n % k;

        for (int i = 0; i < k; i++) {
            ListNode t = null, ptr = null;
            int items = eq + (bal > 0 ? 1 : 0);

            for (int j = 0; j < items && head != null; j++) {
                if (t == null) {
                    t = new ListNode(head.val);
                    ptr = t;
                } else {
                    t.next = new ListNode(head.val);
                    t = t.next;
                }

                head = head.next;
            }

            res[i] = ptr;
            bal -= 1;
        }

        return res;
    }
}