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
 // https://leetcode.com/problems/reorder-list/
class Solution {
    public void reorderList(ListNode head) {
        Deque<ListNode> deq = new ArrayDeque<>();
        ListNode t = head, res = head;

        while (t != null) {
            deq.addLast(t);
            t = t.next;
        }

        while (!deq.isEmpty()) {
            ListNode last = deq.pollLast();
            ListNode temp = head.next;

            if (head == last) break;

            head.next = last;
            last.next = temp;
            head = temp;

            if (!deq.isEmpty())
                deq.removeFirst();  
        }

        head.next = null;
    }
}