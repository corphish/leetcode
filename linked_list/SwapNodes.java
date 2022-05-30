// https://leetcode.com/problems/swapping-nodes-in-a-linked-list
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
    public ListNode swapNodes(ListNode head, int k) {
        int[] arr = new int[100001];
        int n = 0;
        while (head != null) {
            arr[n++] = head.val;
            head = head.next;
        }
        
        // Swap
        int tm = arr[k - 1];
        arr[k - 1] = arr[n - k];
        arr[n - k] = tm;
        
        ListNode res = new ListNode(), t = res, prev = res;
        for (int i = 0; i < n; i++) {
            t.val = arr[i];
            t.next = new ListNode();
            prev = t;
            t = t.next;
        }
        
        if (prev != null) prev.next = null;
        return res;
    }
}