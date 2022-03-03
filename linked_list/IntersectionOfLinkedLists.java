/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// https://leetcode.com/problems/intersection-of-two-linked-lists
// See https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/1768768/Java-Solution-or-4-Approaches-or-Brute-Hashing-Optimal-Best for better approaches
public class Solution {
    // O(m + n) time but O(n) space
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> s = new HashSet<>();
        while (headA != null) {
            s.add(headA);
            headA = headA.next;
        }
        
        while (headB != null) {
            if (s.add(headB))
                headB = headB.next;
            else return headB;
        }
        
        return null;
    }

    public ListNode getIntersectionNodeBest(ListNode headA, ListNode headB) {
        
        ListNode dA = headA;
        ListNode dB = headB;
        
        while (dA != dB){
            dA = dA == null ? headB : dA.next;
            dB = dB == null ? headA : dB.next;
        }
        
        return dB;
    }
}