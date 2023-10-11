/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
// https://leetcode.com/problems/copy-list-with-random-pointer
class Solution {
    Map<Node, Node> map = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node n = new Node(head.val);
        map.put(head, n);
        n.next = copyRandomList(head.next);
        n.random = map.get(head.random);
        return n;
    }
}