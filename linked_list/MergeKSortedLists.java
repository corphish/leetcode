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
 // https://leetcode.com/problems/merge-k-sorted-lists/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(), r = res, t = null;
        
        while (true) {
            int min = Integer.MAX_VALUE, minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        minIndex = i;
                    }
                }
            }
            
            if (minIndex != -1) {
                res.val = min;
                lists[minIndex] = lists[minIndex].next;
                res.next = new ListNode();
                t = res;
                res = res.next;
            } else {
                if (t != null) {
                    t.next = null; 
                } else {
                    r = null;
                }
                
                break;
            }
        }
        
        return r;
    }
}