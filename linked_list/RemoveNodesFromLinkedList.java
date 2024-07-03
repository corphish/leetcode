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
// https://leetcode.com/problems/remove-nodes-from-linked-list 
class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            while (!stack.isEmpty() && stack.peek().val < head.val) {
                stack.pop();
            }

            stack.push(head);
            head = head.next;
        }

        ListNode res = null, list = null;
        for (ListNode node: stack) {
            if (res == null) {
                list = node;
                res = list;
            } else {
                list.next = node;
                list = list.next;
            }
        }

        list.next = null;

        return res;
    }
}