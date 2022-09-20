/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
class Solution {
    public Node flatten(Node head) {
        // System.out.println(accumulate(head));
        return build(accumulate(head));
    }
    
    List<Integer> accumulate(Node head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            
            if (head.child != null) {
                res.addAll(accumulate(head.child));
            }
            
            head = head.next;
        }
        
        return res;
    }
    
    Node build(List<Integer> data) {
        Node head = null, prev = null, res = null;
        
        for (int x: data) {
            if (head == null) {
                head = new Node();
                res = head;
            }
            
            head.val = x;
            head.next = new Node();
            head.prev = prev;
            prev = head;
            head = head.next;
        }
        
        if (prev != null) prev.next = null;
        return res;
    }
}